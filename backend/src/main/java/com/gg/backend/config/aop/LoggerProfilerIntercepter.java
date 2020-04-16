package com.gg.backend.config.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gimi
 */
@Aspect
@Component
@Slf4j
public class LoggerProfilerIntercepter {

  /**
   * 换行符
   */
  private static final String LINE_SEPARATOR = System.lineSeparator();

  @Pointcut("execution(public * com.gg.backend.controller.*.*(..)) ")
  public void pcMethod() {
  }


  @Around("pcMethod()")
  public Object dologProfiler(final ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    Object[] args = joinPoint.getArgs();
    Object response = joinPoint.proceed();
    printLog(
        "========================================== Start ==========================================");
    printLog("URL            : {}", request.getRequestURL().toString());
    printLog("HTTP Method    : {}", request.getMethod());
    printLog("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
        joinPoint.getSignature().getName());
    printLog("IP             : {}", request.getRemoteAddr());
    printLog("Request Args   : {}", JSONObject.toJSONString(args));
    printLog("Response       : {}", JSONObject.toJSONString(response));
    printLog("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
    printLog(
        "=========================================== End ===========================================");
    return joinPoint.proceed();
  }


  public void printLog(String key,Object... value){
    log.info(key,value);
  }

}
