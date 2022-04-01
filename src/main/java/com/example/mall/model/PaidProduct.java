package com.example.mall.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaidProduct {
    private Integer id;
    private Integer parentId;
    private String name;
    private String picture;
    private BigDecimal price;
    private Long gmtBought;
    private Integer count;

}
