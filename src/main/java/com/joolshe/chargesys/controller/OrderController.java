package com.joolshe.chargesys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolshe.chargesys.bean.Order;
import com.joolshe.chargesys.bean.Result;
import com.joolshe.chargesys.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Zexi He.
 * @date 2023/5/17 12:20
 * @description:
 */

@RequestMapping("/orders")
@Slf4j
@Controller
public class OrderController {


    @Resource
    private OrderService orderService;

    @RequestMapping("/queryOrdersPage")
    @ResponseBody
    public Result<?> queryOrdersPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {

        try {
            Page<Order> page = orderService.page(new Page<>(pageNum, pageSize));
            if (page != null) {
                return Result.success("查询成功", page);
            } else {
                return Result.error("server", "查询失败");
            }
        } catch (Exception e) {
            return Result.error("server", e.getMessage());
        }
    }

}
