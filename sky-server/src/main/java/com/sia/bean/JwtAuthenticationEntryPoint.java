package com.sia.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, java.io.IOException {
        // 设置响应状态码和内容类型
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        Throwable cause = authException.getCause();
        String errorMessage;

        // 区分不同类型的认证异常
        if (authException instanceof BadCredentialsException) {
            errorMessage = "用户名或密码错误";
        } else if (cause instanceof ExpiredJwtException) {
            errorMessage = "令牌已过期";
        } else if (cause instanceof MalformedJwtException) {
            errorMessage = "无效的令牌格式";
        }else {
            errorMessage = "认证失败";
        }
        // 构建错误响应体
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("code", 401);
        body.put("msg", errorMessage);

        // 将错误信息写入响应
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}
