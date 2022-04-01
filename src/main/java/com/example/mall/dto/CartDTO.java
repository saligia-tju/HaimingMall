package com.example.mall.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartDTO {
    private String name;
    private String picture;
    private BigDecimal price;
    private Long gmtBought;
    private Integer count;

}
