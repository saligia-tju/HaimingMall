package com.example.mall.controller;

import com.example.mall.mapper.ProductMapper;
import com.example.mall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class PublishController {
    @Autowired(required = false)
    private ProductMapper productMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("name") String name,
            @RequestParam("abs") String abs,
            @RequestParam("urlUpload") String urlUpload,
            @RequestParam("description") String description,
            @RequestParam("price") BigDecimal price) {

        Product product = new Product();
        product.setName(name);
        product.setAbs(abs);

        String picture;
        if (urlUpload != null) {
            picture = urlUpload;
        } else {
            picture = "url"; //fileUpload需要一个fileController
        }

        product.setPicture(picture);
        product.setDescription(description);
        product.setPrice(price);

        //这里需要加一段验证用户

        productMapper.create(product);
        return "redirect:/";
    }

}
