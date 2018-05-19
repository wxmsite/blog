package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author bebetter159
 * date  2018/5/18 21:45
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @RequestMapping("/{categories}")
    public void searchByCategories(){

    }
}
