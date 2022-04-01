package com.example.mall.controller;

import com.example.mall.dto.BoughtProductDTO;
import com.example.mall.dto.ResultDTO;
import com.example.mall.mapper.BoughtProductMapper;
import com.example.mall.mapper.ProductMapper;
import com.example.mall.model.BoughtProduct;
import com.example.mall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class ProductController {

    @Autowired(required = false)
    private ProductMapper productMapper;

    @Autowired(required = false)
    private BoughtProductMapper boughtProductMapper;


    @GetMapping("/product/{id}")
    public String product(@PathVariable(name = "id") Integer id,
                          Model model) {
        Product product = productMapper.getById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product")
    public String putInCart(@RequestBody BoughtProductDTO boughtProductDTO) {
        BoughtProduct boughtProduct = new BoughtProduct();
        Product product = productMapper.getById(boughtProductDTO.getProductId());
        boughtProduct.setName(product.getName());
        boughtProduct.setPicture(product.getPicture());
        boughtProduct.setPrice(product.getPrice());
        boughtProduct.setGmtBought(System.currentTimeMillis());
        boughtProduct.setCount(boughtProductDTO.getCount());
        boughtProduct.setParentId(product.getId());
        boughtProductMapper.create(boughtProduct);
        return "redirect:/";
    }
}
