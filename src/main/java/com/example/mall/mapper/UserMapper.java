package com.example.mall.mapper;

import com.example.mall.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from `user` where `name` = #{username}")
    User getByName(@Param("username") String username);
}
