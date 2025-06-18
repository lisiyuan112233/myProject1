package com.sia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.entity.Orders;
import com.sia.service.OrdersService;
import com.sia.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author 32156
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2025-06-16 19:55:02
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService {

}




