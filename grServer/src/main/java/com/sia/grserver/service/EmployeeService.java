package com.sia.grserver.service;

import com.sia.grserver.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* @author 32156
* @description 针对表【employee(员工信息)】的数据库操作Service
* @createDate 2025-06-17 12:18:57
*/
public interface EmployeeService extends IService<Employee>, UserDetailsService {

}
