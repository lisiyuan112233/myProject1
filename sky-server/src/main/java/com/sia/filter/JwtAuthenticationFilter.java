package com.sia.filter;

import com.sia.Utils.EmployeeUtil;
import com.sia.Utils.JwtUtil;
import com.sia.constant.RedisConstant;
import com.sia.entity.Employee;
import com.sia.service.EmployeeService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtils;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeUtil employeeUtil;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();

        // 1. 已认证用户无需重复过滤
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return true;
        }

        // 2. 公开路径白名单（排除认证）
        return path.startsWith("/admin/employee/login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
        try {
            // 1. 提取JWT令牌
            String token = jwtUtils.extractToken(request);
            if (token == null||!jwtUtils.validateToken(token)) {
                logger.error("JWT认证失败");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"code\":401,\"message\":认证失败}");
                response.flushBuffer();
                return;
            }
            // 3. 从令牌获取用户名
             String username = jwtUtils.getUsernameFromToken(token);
            // 4. 加载用户信息
            Employee employee= employeeService.lambdaQuery().eq(Employee::getUsername, username).one();
            UserDetails userDetails=employeeService.mapToUserDetails(employee) ;

            // 2. 验证令牌是否过期
            Boolean b = stringRedisTemplate.opsForSet().isMember(RedisConstant.TOKEN_USER+username, token);
            if (Boolean.FALSE.equals(b)){
                logger.error("JWT认证失败");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"code\":401,\"message\":令牌失效,请重新登录}");
                response.flushBuffer();
                return;
            }


            if (username == null) {
                throw new JwtException("Invalid username in JWT token");
            }


            if (userDetails == null) {
                throw new JwtException("User not found");
            }

            // 5. 构建认证对象并设置到Security上下文
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            employeeUtil.setEmployeeId(employee.getId());
            // 6. 继续执行过滤器链
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            // 异常处理：记录日志并返回错误响应
            logger.error("JWT认证失败", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"code\":401,\"msg\":" + e.getMessage() + "}");
            response.flushBuffer();
        }
    }
}
