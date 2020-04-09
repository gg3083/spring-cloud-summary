//package com.example.user.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 自定义个一个authenticationEntryPoint，实现如果无访问权限跳转到登录页面
// * @author sola
// */
//public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {
//
//    @Value("http://localhost:8082/loginPage")
//    private String serverUrl;
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException)
//            throws ServletException {
//        try {
//            System.out.println("进入Entry方法");
//            response.sendRedirect(serverUrl);
//        } catch (Exception e) {
//            throw new ServletException();
//        }
//    }
//}
