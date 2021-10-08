package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DELL
 * @date 2020/3/25 15:01
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
//        log.info("开始新建订单");
//        orderDao.create(order);

        log.info("订单微服务开始调用库存，Count做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("订单微服务开始调用库存，Count做扣减end");
//        int i = 1/0;
        log.info("订单微服务开始调用库存，Money做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("订单微服务开始调用库存，Money做扣减end");

//        log.info("修改订单状态开始");
//        orderDao.update(order.getUserId(),0);
//        log.info("修改订单状态开始end");

    }
}
