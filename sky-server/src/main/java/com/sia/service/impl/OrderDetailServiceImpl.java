package com.sia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.entity.OrderDetail;
import com.sia.service.OrderDetailService;
import com.sia.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author 32156
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2025-06-16 19:54:59
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService {

}




