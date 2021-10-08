package com.atguigu.srpingcloud.dao;


import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author DELL
 * @date 2020/3/12 11:09
 */
@Mapper
public interface PaymentDao
{
    @Insert("INSERT INTO payment(SERIAL) VALUES(#{serial})")
    int create(Payment payment);

    @Select("SELECT * FROM payment WHERE id = #{id}")
    Payment getPaymentById(@Param("id") Long id);
}
