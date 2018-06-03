package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.blog.pojo.BlogResult;
import com.blog.service.PrivilegeService;
import com.blog.service.UserService;
import com.blog.utils.CookieUtil;
import com.blog.utils.JavaWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * author bebetter159
 * date  时间未详
 */
@Controller
@RequestMapping("/Person")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    PrivilegeService privilegeService;

    /**
     * 加载后台管理界面
     * 会被LoginInterceptor拦截
     *
     * @return
     */
    @RequestMapping("/user")
    public String backManage() {
        return "redirect:/user/userInfo";
    }

    @RequestMapping("commonUser")
    public String commonUser() {
        return "CommonUser";
    }


    /**
     * 拦截后没有cookie跳转此处登录
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/registerPage")
    public String showRegister() {
        return "register";
    }

    /**
     * @param model
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", method ={ RequestMethod.POST})
    public String register(Model model, @RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("email") String email) {

        Map<String, String> map = userService.register(username, password);
        if (!map.containsKey("success")) {
            model.addAttribute("msg", map.get("msg"));
            return "register";
        } else {
            return "redirect:/Person/commonUser";
        }
    }


    /**
     * 登录密码验证，以及用户权限验证
     *
     * @param response
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String login(Model model,HttpServletResponse response,
                 @RequestParam String username, @RequestParam String password) {

        String privilege = "";
        Map<String, String> map = userService.login(username, password);
        if (map.containsKey("success")) {
            if ((privilege = userService.getPrivilege(username)).equals("Admin")) {
                Map<String, Object> loginInfo = new HashMap<>();
                loginInfo.put("login", "yes");
                loginInfo.put("timestamp", new Date());
                String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
                System.out.println(sessionId);
                CookieUtil.addCookie(response, "login", sessionId);
                return "redirect:/user/userInfo";
            } else if (privilege.equals("CommonUser")) {
                return "redirect:/Person/commonUser";
            }
        } else {
            model.addAttribute("msg",map.get("msg"));
            return "login";
        }


        return null;
    }

    /**
     * 退出登录
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/logOut", method = {RequestMethod.GET})
    public String loginOut(HttpServletResponse response) {
        CookieUtil.deleteCookie(response, "login");
        return "redirect:/";
    }

}
