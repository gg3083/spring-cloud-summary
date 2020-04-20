package com.gg.backend.config.oauth;

import com.gg.backend.domain.po.JsonBack;
import com.gg.backend.util.JsonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws ServletException {
        Map<String, Object> map = new HashMap<String, Object>();
        Throwable cause = authException.getCause();

        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            if(cause instanceof InvalidTokenException) {
                response.getWriter().write(JsonUtil.beanToJson(JsonBack.buildErrorJson("Token无效")));
            }else{
                response.getWriter().write(
                        JsonUtil.beanToJson(
                            new JsonBack(JsonBack.JSON_BACK_FAILED,"401","需要鉴权",null)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
