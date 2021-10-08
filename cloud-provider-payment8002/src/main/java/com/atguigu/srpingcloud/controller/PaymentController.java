package com.atguigu.srpingcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.srpingcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author DELL
 * @date 2020/3/12 11:27
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果："+result);

        if(result > 0 ) return new CommonResult(200,"success,serverPort:"+serverPort,result);
        else return new CommonResult(444,"failed,serverPort:"+serverPort);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******插入结果："+payment);

        if(payment != null ) return new CommonResult(200,"success!serverPort:"+serverPort,payment);
        else return new CommonResult(444,"failed!!serverPort:"+serverPort);
    }
}
