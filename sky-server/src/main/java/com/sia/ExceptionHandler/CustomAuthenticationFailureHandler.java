package com.sia.ExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // 根据异常类型返回不同的错误信息
        String errorMessage = "认证失败";
        if (exception instanceof UsernameNotFoundException) {
            errorMessage = "用户不存在";
        } else if (exception instanceof BadCredentialsException) {
            errorMessage = "密码错误";
        } else if (exception instanceof DisabledException) {
            errorMessage = "用户已禁用";
        }

        // 返回JSON格式的错误响应
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("code", HttpServletResponse.SC_UNAUTHORIZED);
        errorResponse.put("msg", errorMessage);

        response.getWriter().write(mapper.writeValueAsString(errorResponse));
    }
}
