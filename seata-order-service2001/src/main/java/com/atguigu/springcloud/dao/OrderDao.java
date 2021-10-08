package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderDao {
    @Insert("INSERT INTO t_order(user_id,product_id,count,money,status) " +
            "VALUES(null,#{userId},#{productId},#{count},#{money},0)")
    void create(Order order);

    @Update("UPDATE t_order SET status = 1 WHERE user_id = #{userId} and status = #{status}")
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
