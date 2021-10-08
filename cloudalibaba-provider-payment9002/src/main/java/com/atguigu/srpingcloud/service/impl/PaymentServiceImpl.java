package com.atguigu.srpingcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.srpingcloud.dao.PaymentDao;
import com.atguigu.srpingcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DELL
 * @date 2020/3/12 11:24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
