package com.sia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.entity.Category;
import com.sia.service.CategoryService;
import com.sia.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 32156
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2025-06-16 19:54:49
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService {

}




