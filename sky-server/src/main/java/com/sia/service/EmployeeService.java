package com.sia.service;

import com.sia.dto.EmployeeDTO;
import com.sia.dto.EmployeePageQueryDTO;
import com.sia.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sia.result.Result;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* @author 32156
* @description 针对表【employee(员工信息)】的数据库操作Service
* @createDate 2025-06-16 19:29:41
*/
public interface EmployeeService extends IService<Employee> , UserDetailsService {
    UserDetails mapToUserDetails(Employee user);
    Result addEmployee(EmployeeDTO employeeDTO);
    Result getPage(EmployeePageQueryDTO pageQueryDTO);
}
