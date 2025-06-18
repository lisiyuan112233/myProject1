package com.sia.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.Utils.EmployeeUtil;
import com.sia.constant.StatusConstant;
import com.sia.dto.EmployeeDTO;
import com.sia.entity.Employee;
import com.sia.result.Result;
import com.sia.service.EmployeeService;
import com.sia.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author 32156
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2025-06-16 19:29:41
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeUtil employeeUtil;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = this.lambdaQuery().eq(Employee::getUsername, username).one();
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }else if (Objects.equals(user.getStatus(), StatusConstant.DISABLE)){
            throw new UsernameNotFoundException("用户已禁用");
        }
        return mapToUserDetails(user);
    }

    @Override
    public UserDetails mapToUserDetails(Employee user) {
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .disabled(false)
                .build();
    }

    @Override
    public Result addEmployee(EmployeeDTO employeeDTO) {
        Employee one = lambdaQuery().eq(Employee::getUsername, employeeDTO.getUsername()).one();
        if (one!= null) {
            return Result.error("用户名已存在");
        }
        Employee employee = new Employee();
        BeanUtil.copyProperties(employeeDTO, employee);
        employee.setPassword(passwordEncoder.encode("123456"));
        employee.setStatus(StatusConstant.ENABLE);
        employee.setCreateUser(employeeUtil.getEmployeeId());
        employee.setUpdateUser(employeeUtil.getEmployeeId());
        boolean save = save(employee);
        return save ? Result.success("添加成功") : Result.error("添加失败");
    }
}



