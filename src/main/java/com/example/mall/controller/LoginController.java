package com.example.mall.controller;


import com.example.mall.mapper.UserMapper;
import com.example.mall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            HttpServletRequest request) {
        User verifiedUser = userMapper.getByName(userName);

        String verifiedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (verifiedUser.getPassword().equals(verifiedPassword)) {
            //密码验证成功，写cookie和session
            request.getSession().setAttribute("user", verifiedUser);
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
