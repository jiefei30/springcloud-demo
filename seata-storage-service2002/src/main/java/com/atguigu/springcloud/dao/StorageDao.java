package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageDao {
    @Update("UPDATE t_storage SET used = used + #{count} , residue = residue - #{count} " +
            "WHERE product_id = #{productId}")
    void decrease(@Param("productId") Long productId , @Param("count") Integer count);
}
