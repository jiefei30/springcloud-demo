package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author DELL
 * @date 2020/3/14 16:38
 */
@Component
public class PaymenFeignServiceImpl implements PaymentFeignService {

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult(444,"客户端Feigin降级");
    }
}
