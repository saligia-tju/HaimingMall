package com.example.mall.mapper;

import com.example.mall.model.BoughtProduct;
import com.example.mall.model.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoughtProductMapper {
    @Insert("INSERT INTO `boughtproduct`(`name`, `picture`, `price`, `gmtBought`, `count`,`parentId`) VALUES (#{name}, #{picture},#{price},#{gmtBought},#{count},#{parentId})")
    void create(BoughtProduct boughtProduct);

    @Select("select * from boughtproduct")
    List<BoughtProduct> list();

    @Delete("delete from `boughtproduct` where `id` = #{id}")
    void delete(BoughtProduct boughtProduct);

    @Delete("delete from `boughtproduct`")
    void clear();
}

