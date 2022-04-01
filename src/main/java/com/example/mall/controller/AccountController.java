package com.example.mall.controller;

import com.example.mall.mapper.PaidProductMapper;
import com.example.mall.model.PaidProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class AccountController {
    @Autowired(required = false)
    private PaidProductMapper paidProductMapper;

    @GetMapping("/account")
    public String account(Model model) {

        List<PaidProduct> productList = paidProductMapper.list();
        BigDecimal amount = new BigDecimal(0.00);
        for (PaidProduct paidProduct : productList) {
            BigDecimal bigDecimal1 = new BigDecimal(paidProduct.getCount());
            BigDecimal bigDecimal2 = bigDecimal1.multiply(paidProduct.getPrice());
            amount = amount.add(bigDecimal2);
        }
        model.addAttribute("paidProducts", productList);
        model.addAttribute("amount", amount);

        return "account";
    }

}
