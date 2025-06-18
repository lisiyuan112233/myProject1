package com.sia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.entity.Dish;
import com.sia.service.DishService;
import com.sia.mapper.DishMapper;
import org.springframework.stereotype.Service;

/**
* @author 32156
* @description 针对表【dish(菜品)】的数据库操作Service实现
* @createDate 2025-06-16 19:54:52
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

}




