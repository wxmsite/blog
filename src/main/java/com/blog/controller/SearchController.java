package com.blog.controller;

import com.blog.JedisDao.impl.JedisClientSingle;
import com.blog.Mapper.SearchMapper;
import com.blog.model.BlogDetail;
import com.blog.pagehelper.Page;
import com.blog.service.BlogService;
import com.blog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    JedisClientSingle jedisClientSingle;
    @Autowired
    SearchMapper searchMapper;

    @RequestMapping("/search/c")
    public String searchByCategories(Model model, @RequestParam("category") String c,
                                     @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        List<BlogDetail> blogDetails = searchMapper.searchByCategories(c);
        for(BlogDetail blogDetail:blogDetails){
            System.out.println(blogDetail.toString()+"12233");
        }
        long count = searchService.getCount();
        Page page = new Page(blogDetails, pn, count, 8);
        model.addAttribute("allBlog", page);
        model.addAttribute("count", count);
        long pv = jedisClientSingle.getAndputPv();
        model.addAttribute("countPv", pv);
        return "index";
    }

    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam("keyword") String keyword,
                         @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        List<BlogDetail> blogList = searchService.searchBlogLucene(keyword, pn);

        long count = searchService.getCount();

        Page page = new Page(blogList, pn, count, 8);
        model.addAttribute("allBlog", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("count", count);
        long pv = jedisClientSingle.getAndputPv();
        model.addAttribute("countPv", pv);
      /*  PageHelper.startPage(pn, 3);
        List<Blog> blogList = searchService.searchBlog(keyword,pn);
        System.out.println(blogList.size());
        PageInfo page = new PageInfo(blogList, 5);
        model.addAttribute("allBlog", page);
        model.addAttribute("keyword",keyword);*/
        return "index";
    }
}
