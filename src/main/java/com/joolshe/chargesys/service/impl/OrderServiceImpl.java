package com.joolshe.chargesys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joolshe.chargesys.bean.Order;
import com.joolshe.chargesys.mapper.OrderMapper;
import com.joolshe.chargesys.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/17 11:49
 * @description:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public void addBatchUsers(List<Order> orders) {

        orderMapper.insertBatch(orders);
    }
}
