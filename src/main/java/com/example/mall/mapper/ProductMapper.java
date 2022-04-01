package com.example.mall.mapper;

import com.example.mall.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO `product`(`name`, `picture`, `abs`, `description`, `price`) VALUES (#{name}, #{picture},#{abs},#{description},#{price})")
    void create(Product product);

    @Select("select * from product")
    List<Product> list();

    @Select("select * from product where id = #{id}")
    Product getById(@Param("id") Integer id);
}
