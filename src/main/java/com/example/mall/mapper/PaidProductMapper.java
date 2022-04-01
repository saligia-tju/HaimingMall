package com.example.mall.mapper;

import com.example.mall.model.BoughtProduct;
import com.example.mall.model.PaidProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaidProductMapper {
    @Insert("INSERT INTO `paidproduct`(`name`, `picture`, `price`, `gmtBought`, `count`,`parentId`) VALUES (#{name}, #{picture},#{price},#{gmtBought},#{count},#{parentId})")
    void create(BoughtProduct boughtProduct);

    @Select("select * from paidproduct")
    List<PaidProduct> list();
}

