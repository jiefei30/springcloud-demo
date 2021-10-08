package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author DELL
 * @date 2020/3/12 15:04
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    public RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    public String PAYMENT_URL;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getNotice(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/nacos/"+id,String.class);
    }
}
