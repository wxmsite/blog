package com.blog.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.blog.pojo.BlogResult;
import com.blog.service.UserInfoService;
import com.blog.utils.CookieUtil;
import com.blog.utils.JavaWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Person")
public class PersonController {
    @Autowired
    UserInfoService userInfoService;

    /**
     * 加载后台管理界面
     * 会被LoginInterceptor拦截
     * @return
     */
    @RequestMapping("/user")
    public String backManage() {
       return "redirect:/user/userInfo";
    }

    /**
     * 拦截后没有cookie跳转此处登录
     * @return
     */
    @RequestMapping("/loginPage")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String showRegister() {
        return "register";
    }

    @RequestMapping("/CommonUser")
    public String common() {
        return "CommonUser";
    }

    /**
     * 登录密码验证，以及用户权限验证
     * @param response
     * @param username
     * @param password
     * @param printWriter
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    void login(HttpServletResponse response, @RequestParam String username, @RequestParam String password, PrintWriter printWriter) {
        BlogResult result = null;
        String privilege = "";
        if (password.equals(userInfoService.getUserByName(username).getPassword())) {
            if ((privilege = userInfoService.getPrivilege(username)).equals("Admin")) {
                result = new BlogResult("1");
                Map<String, Object> loginInfo = new HashMap<>();
                loginInfo.put("login", "yes");
                loginInfo.put("timestamp", new Date());
                String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
                System.out.println(sessionId);
                CookieUtil.addCookie(response,"login",sessionId);
            } else if (privilege.equals("commonUser")) {
                result = new BlogResult("2");
            }
        } else {
            result = BlogResult.wrong();
        }
        String jsonString = JSON.toJSONString(result, SerializerFeature.PrettyFormat);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 退出登录
     * @param response
     * @return
     */
    @RequestMapping(value = "/logOut", method = {RequestMethod.GET})
    public String loginOut( HttpServletResponse response) {
        CookieUtil.deleteCookie(response,"login");
        return "redirect:/";
    }

}
