package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author DELL
 * @date 2020/3/25 19:46
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(){
        Order order = new Order();
        order.setCount(1);
        order.setMoney(new BigDecimal("10"));
        order.setProductId(1L);
        order.setUserId(1L);
        order.setStatus(0);
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
