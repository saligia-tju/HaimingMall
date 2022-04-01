package com.example.mall.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Integer id;
    private String name;
    private String picture;
    private String abs;
    private String description;
    private BigDecimal price;
}