package com.sia.interceptor;

import com.sia.Utils.EmployeeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class clearInterceptor implements HandlerInterceptor {
    @Autowired
    private EmployeeUtil employeeUtil;
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        employeeUtil.remove();
    }
}
