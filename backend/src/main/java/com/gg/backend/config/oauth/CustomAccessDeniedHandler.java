package com.gg.backend.config.oauth;

import com.gg.backend.domain.dto.JsonBack;
import com.gg.backend.util.JsonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(
                    JsonUtil.beanToJson(
                            new JsonBack(JsonBack.JSON_BACK_FAILED,"500","权限不足",null)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
