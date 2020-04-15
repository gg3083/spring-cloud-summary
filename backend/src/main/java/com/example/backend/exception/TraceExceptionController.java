package com.example.backend.exception;

import com.alibaba.fastjson.JSON;
import com.example.backend.domain.po.JsonBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/***
 *
 * 捕获异常
 * @author Gimi
 * @date 2019-06-19 21:37:07
 *
 ***/
//@RestControllerAdvice
@Slf4j
public class TraceExceptionController extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JsonBack> errorJson(Throwable exp, HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        int statusInt  = status.value();
        log.info("errorJson.Accept:{},Content-Type:{},exp:{}",new Object[]{request.getHeader("Accept"),request.getHeader("Content-Type").toString(),exp==null?null:exp.getMessage()});
        log.info("errorJson.exp",exp);

        JsonBack        jsonBack = null;
        Map<String, Object> _err = null;
        if(exp!=null && exp instanceof CustomException){
            jsonBack = new JsonBack((CustomException)exp);

        }else if(exp!=null && exp instanceof MissingServletRequestParameterException) {
            String parameterName = ((MissingServletRequestParameterException) exp).getParameterName();
            jsonBack = new JsonBack(JsonBack.JSON_BACK_FAILED, CustomExceptionType.VALIDATE_ERR.getErrorCode(), "参数" + parameterName + "输入有误", "missing.request.parameter:" + parameterName);
        } else if (exp != null && exp instanceof MethodArgumentNotValidException){
            String errMsg = "请求参数验证失败";
            try {
                errMsg = ((MethodArgumentNotValidException)exp).getBindingResult().getAllErrors().get(0).getDefaultMessage();
            }catch (Exception e){}
            jsonBack = new JsonBack(JsonBack.JSON_BACK_FAILED, CustomExceptionType.VALIDATE_ERR.getErrorCode(), errMsg, exp.getMessage());
        } else{
            String msgVal = null;
            try {
                msgVal = exp.getCause()==null?exp.getMessage():exp.getCause().getMessage();
            } catch (Exception e) {
                jsonBack = new JsonBack(JsonBack.JSON_BACK_FAILED, CustomExceptionType.VALIDATE_ERR.getErrorCode(), msgVal, exp.getMessage());
            }
            log.error("errorJson.errdata is:{}", JSON.toJSONString(_err));
        }
        return new ResponseEntity<JsonBack>(jsonBack, HttpStatus.OK);
    }


    /**
     * 获取错误编码
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}