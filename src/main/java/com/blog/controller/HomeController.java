package com.blog.controller;

import com.blog.JedisDao.impl.JedisClientSingle;
import com.blog.model.BlogDetail;
import com.blog.pagehelper.Page;
import com.blog.pagehelper.PageConstant;
import com.blog.service.BlogService;
import com.blog.service.ExpertUrlService;
import com.blog.service.SearchService;
import com.blog.utils.AuthUtil;
import com.blog.utils.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 */
@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    JedisClientSingle jedisClientSingle;
    @Autowired
    ExpertUrlService expertUrlService;
    @Autowired
    BlogService blogService;
    @Autowired
    SearchService searchService;


    @RequestMapping("/")
    public String home(HttpServletRequest request, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        long pv;
        try {
            pv = jedisClientSingle.getAndputPv();
        } catch (Exception e) {
            logger.error("连接Redis错误");
            pv = 0;
        }
        model.addAttribute("countPv", pv);
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
        List<BlogDetail> blogList = blogService.getAllPersonalBlog(pn, PageConstant.PAGE_SIZE);
        int count = blogService.getCount();
        Page page = new Page(blogList, pn, count, 8);
        model.addAttribute("count", count);
        model.addAttribute("allBlog", page);
        /*PageHelper.startPage(pn, 3);
        List<BlogDetail> blogList2 =blogService.getAllPersonalBlog();
        PageInfo page2=new PageInfo(blogList2);
        model.addAttribute("allBlog",page2);*/
        return "index";
    }
}
