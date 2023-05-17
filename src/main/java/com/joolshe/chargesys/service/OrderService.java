package com.joolshe.chargesys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joolshe.chargesys.bean.Order;

import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/17 11:48
 * @description:
 */
public interface OrderService extends IService<Order> {

    void addBatchUsers(List<Order> orders);
}
