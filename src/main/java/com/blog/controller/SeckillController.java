package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author bebetter159
 * date  2018/6/3 20:22
 */
@Controller
public class SeckillController {
    @RequestMapping("/seckill")
    @ResponseBody
    public  String seckill(){
        return "123";
    }
}
