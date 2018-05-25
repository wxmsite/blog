package com.blog.controller;

import com.blog.JedisDao.impl.JedisClientSingle;
import com.blog.model.Blog;
import com.blog.pagehelper.Page;
import com.blog.service.ExpertBlogService;
import com.blog.service.ExpertUrlService;
import com.blog.service.SearchService;
import com.blog.utils.AuthUtil;
import com.blog.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * author bebetter159
 * date  时间未详
 */
@Controller
public class HomeController {
    @Autowired
    JedisClientSingle jedisClientSingle;
    @Autowired
    ExpertUrlService expertUrlService;
    @Autowired
    ExpertBlogService expertBlogService;
    @Autowired
    SearchService searchService;
    /*初始keyword*/
    private String keyword = "Java";

    @RequestMapping("/")
    public String home(HttpServletRequest request, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        long pv = jedisClientSingle.getAndputPv();
        model.addAttribute("count", pv);
        String sessionid = CookieUtil.getByName(request, "login");
        if (sessionid != null) {
            Map<String, Object> map = AuthUtil.decodeSession(sessionid);
            String loginStatus = (String) map.get("login");
            Long timestamp = (Long) map.get("timestamp");
            if (loginStatus != null && timestamp != null && new Date().getTime() - timestamp < 1000 * 60 * 60 * 24) {
                model.addAttribute("status", true);
            }
        } else
            model.addAttribute("status", false);
        List<Blog> blogList = searchService.searchBlog("Java", pn);
        long count=searchService.getCount();
        Page page=new Page(blogList,pn,count,10);
        model.addAttribute("allBlog",page);
        model.addAttribute("keyword", "Java");

        /*PageHelper.startPage(pn, 20);
        List<Blog> blogList =expertBlogService.getAllblog();
        PageInfo page=new PageInfo(blogList,1);
        model.addAttribute("allBlog",page);*/
       /* List<ExpertUrl> userInfos = expertUrlService.getAllExpertUrl();
        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(userInfos, 5);
        model.addAttribute("allBlog", page);*/
        return "index";
    }
}
