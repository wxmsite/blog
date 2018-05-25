package com.blog.controller;

import com.blog.model.Blog;
import com.blog.pagehelper.Page;
import com.blog.service.ExpertBlogService;
import com.blog.service.SearchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/18 21:45
 */
@Controller

public class SearchController {
    @Autowired
    SearchService searchService;
    @Autowired
    ExpertBlogService expertBlogService;

    @RequestMapping("/{categories}")
    public void searchByCategories() {

    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword,
                         @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        List<Blog> blogList = searchService.searchBlog(keyword, pn);
        long count=searchService.getCount();
        Page page=new Page(blogList,pn,count,10);
        model.addAttribute("allBlog",page);
        model.addAttribute("keyword", keyword);
      /*  PageHelper.startPage(pn, 3);
        List<Blog> blogList = searchService.searchBlog(keyword,pn);
        System.out.println(blogList.size());
        PageInfo page = new PageInfo(blogList, 5);
        model.addAttribute("allBlog", page);
        model.addAttribute("keyword",keyword);*/
     /*
        PageHelper.startPage(pn, 20);
        List<Blog> blogList =expertBlogService.getAllblog();
        PageInfo page=new PageInfo(blogList,5);
        model.addAttribute("allBlog",page);*/

        return "index";
    }
}
