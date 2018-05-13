package com.blog.controller;

import com.blog.JedisDao.impl.JedisClientSingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @Autowired
    JedisClientSingle jedisClientSingle;
    @RequestMapping("/")
    public String home(Model model) {
        long pv = jedisClientSingle.getAndputPv();
        model.addAttribute("count", pv);
        return "index";
    }
}
