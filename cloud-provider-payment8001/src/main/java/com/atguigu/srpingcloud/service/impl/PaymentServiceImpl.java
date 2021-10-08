package com.atguigu.srpingcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.srpingcloud.dao.PaymentDao;
import com.atguigu.srpingcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author DELL
 * @date 2020/3/12 11:24
 */
@Service
@DefaultProperties(defaultFallback = "globleHandler")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    @HystrixCommand
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPaymentById_Handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000"),
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器——熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数——熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "1000"), //时间窗口期——熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "40"),//失败率达到多少后跳闸——熔断
    })
    public Payment getPaymentById(Long id) {
//        try {
//            Thread.sleep(4000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return paymentDao.getPaymentById(id);
    }


    public Payment getPaymentById_Handler(Long id) {
        return new Payment().setId(Long.parseLong("0")).setSerial("服务降级");
    }

    public Payment globleHandler(Long id) {
        return new Payment().setId(Long.parseLong("0")).setSerial("全局默认服务降级");
    }

}
