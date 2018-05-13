package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.blog.model.Person;
import com.blog.model.UserInfo;
import com.blog.pojo.BlogResult;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/Blog")
public class BlogController {
    @Autowired
    BlogService blogService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    void ajax(@RequestParam String username, @RequestParam String password, PrintWriter printWriter) {
        BlogResult result;
        List<UserInfo> list = Db.getAll();
        for (UserInfo u : list) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                result = new BlogResult("123");
                Person person=new Person("1","2");
                String jsonString = JSON.toJSONString(person, SerializerFeature.PrettyFormat);
                System.out.print(jsonString);
                printWriter.write(jsonString);
                printWriter.flush();
                printWriter.close();
            }
        }
        result = new BlogResult("");
        String jsonString = JSON.toJSONString(result, SerializerFeature.PrettyFormat);
        System.out.print(jsonString);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();

    }

    static class Db {
        public static List<UserInfo> list = new ArrayList<UserInfo>();

        static {
            list.add(new UserInfo("aaa", "123",new Date()));
            list.add(new UserInfo("bbb", "123",new Date()));
            list.add(new UserInfo("ccc", "123",new Date()));
        }

        public static List<UserInfo> getAll() {
            return list;
        }

    }
}
