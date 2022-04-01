package com.example.mall.controller;

import com.example.mall.mapper.BoughtProductMapper;
import com.example.mall.mapper.PaidProductMapper;
import com.example.mall.model.BoughtProduct;
import com.example.mall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    @Autowired(required = false)
    private BoughtProductMapper boughtProductMapper;

    @Autowired(required = false)
    private PaidProductMapper paidProductMapper;

    @GetMapping("/cart")
    public String cart(Model model,
                       @RequestParam(name = "name", required = false) String name) {
        model.addAttribute("name", name);

        // 首页商品
        List<BoughtProduct> boughtProductList = boughtProductMapper.list();
        model.addAttribute("boughtProducts", boughtProductList);
        return "cart";

    }

    @PostMapping("/cart")
    public String payForCart() {
        List<BoughtProduct> boughtProductList = boughtProductMapper.list();
        for (BoughtProduct boughtProduct : boughtProductList) {
            paidProductMapper.create(boughtProduct);
        }
        boughtProductMapper.clear();
        return "redirect:/";
    }
}

