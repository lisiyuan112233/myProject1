package com.sia.grserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.grserver.entity.Employee;
import com.sia.grserver.service.EmployeeService;
import com.sia.grserver.mapper.EmployeeMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
* @author 32156
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2025-06-17 12:18:57
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = this.lambdaQuery().eq(Employee::getUsername, username).one();
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return mapToUserDetails(user);
    }

    private UserDetails mapToUserDetails(Employee user) {
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .disabled(false)
                .build();
    }
}




