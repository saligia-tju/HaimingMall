package com.example.mall.controller;

import com.example.mall.mapper.ProductMapper;
import com.example.mall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "name", required = false) String name) {
        model.addAttribute("name", name);

        // 首页商品
        List<Product> productList = productMapper.list();
        model.addAttribute("products", productList);

        return "index";
    }
}

