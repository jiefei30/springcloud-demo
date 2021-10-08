package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    @Update("UPDATE t_account SET residue = residue - #{money}, used = used + #{money} WHERE user_id = #{userId}")
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
