package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * author bebetter159
 * date  时间未详
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @RequestMapping("/categories")
    public void searchByCategories(){

    }
}
