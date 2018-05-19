package com.blog.interceptor;

import com.blog.utils.AuthUtil;
import com.blog.utils.CookieUtil;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
/**
 * author bebetter159
 * date   时间未详
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception err) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        //获取登录cookie
        String cookie= CookieUtil.getByName(request,"login");
        if (cookie!=null){
             Map<String,Object> map= AuthUtil.decodeSession(cookie);
            String loginStatus= (String) map.get("login");
            Long timestamp= (Long) map.get("timestamp");
            if (loginStatus!=null&&timestamp!=null&&new Date().getTime()-timestamp<1000*60*60*24){
                return true;
            }
        }
        //没有发现cookie返回登录页面，返回false不执行controller的方法
        response.sendRedirect("/Person/loginPage");
        return false;
    }
}