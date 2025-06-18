package com.sia.Utils;

import org.springframework.stereotype.Component;

@Component
public class EmployeeUtil {
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public void setEmployeeId(String employeeId) {
        threadLocal.set(employeeId);
    }
    public String getEmployeeId() {
        return threadLocal.get();
    }
    public void remove() {
        threadLocal.remove();
    }
}
