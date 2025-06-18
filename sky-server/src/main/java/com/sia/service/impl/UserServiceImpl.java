package com.sia.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.entity.User;
import com.sia.service.UserService;
import com.sia.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 32156
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2025-06-16 19:55:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
    public static void main(String[] args) {
        System.out.println(IdUtil.simpleUUID());
    }
}




