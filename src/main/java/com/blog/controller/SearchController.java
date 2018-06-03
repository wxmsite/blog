package com.blog.controller;

import com.blog.model.BlogDetail;
import com.blog.pagehelper.Page;
import com.blog.service.BlogService;
import com.blog.service.SearchService;
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
    BlogService blogService;

    @RequestMapping("/{categories}")
    public void searchByCategories() {

    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword,
                         @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        List<BlogDetail> blogList = searchService.searchBlogLucene(keyword ,pn);
        for(BlogDetail blogDetail:blogList){
            System.out.println(blogDetail.getTitle());
        }
        long count=searchService.getCount();
        System.out.println(count);
        Page page=new Page(blogList,pn,count,8);
        model.addAttribute("allBlog",page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("count",count);
      /*  PageHelper.startPage(pn, 3);
        List<Blog> blogList = searchService.searchBlog(keyword,pn);
        System.out.println(blogList.size());
        PageInfo page = new PageInfo(blogList, 5);
        model.addAttribute("allBlog", page);
        model.addAttribute("keyword",keyword);*/
        return "index";
    }
}
