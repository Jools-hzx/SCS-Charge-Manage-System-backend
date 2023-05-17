package com.joolshe.chargesys.service;

import com.joolshe.chargesys.bean.Order;
import com.joolshe.chargesys.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/17 12:00
 * @description:
 */

@SpringBootTest
public class OrderServiceTest {


    @Resource
    private OrderService orderService;

    //批量插入测试数据
    @Test
    public void insertBatchOrdersTest() {

        List<Order> orders = new ArrayList<>();

        for (int i = 1; i < 20; i++) {
            Order order = new Order();
            order.setOrderId(Utils.getRandomSerialNumber());
            order.setStatus(0);
            order.setUserId(i);
            order.setStatus(1);
            order.setCreateTime(LocalDateTime.now());
            order.setPrice(new BigDecimal(2 * i));
            order.setChargerId(1);
            order.setStationId(1);

            orders.add(order);
        }

        for (int i = 1; i < 20; i++) {
            Order order = new Order();
            order.setOrderId(Utils.getRandomSerialNumber());
            order.setStatus(0);
            order.setUserId(i);
            order.setStatus(0);
            order.setCreateTime(LocalDateTime.now());
            order.setPrice(new BigDecimal(2 * i));
            order.setStationId(1);
            order.setChargerId(1);

            orders.add(order);
        }

        orderService.addBatchUsers(orders);
    }
}
