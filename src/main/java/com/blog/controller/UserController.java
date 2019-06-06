package com.blog.controller;

import com.blog.model.User;
import com.blog.service.PrivilegeService;
import com.blog.service.UserService;
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

 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final PrivilegeService privilegeService;

    @Autowired
    public UserController(UserService userService, PrivilegeService privilegeService) {
        this.userService = userService;
        this.privilegeService = privilegeService;
    }


    /**
     * 更新用户数据
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String UpdateUser(Model model, User user) {
        //更新user表和privilege表
        if (userService.updateUser(user) && privilegeService.updatePrivilege(user.getUserPrivilege())) {
            user = userService.findUserById(user.getId());
            model.addAttribute("user", user);
            return "redirect:/user/userInfo";
        }
        return "/error";
    }

    /**
     * 获取所有用户数据
     * @param model
     * @return
     */
    @RequestMapping("/getAllUser")
    public String getAllUser(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("userList", user);
        return "user";
    }

    /**
     * 查询用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "editUser";
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/delUser")
    public String deleteUser(int id, Model model) {
        model.addAttribute("user", userService.deleteUser(id));
        return "redirect:/user/userInfo";
    }

    /**
     * 分页查询用户
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/userInfo")
    public String getUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //从第一条开始 每页查询五条数据
        PageHelper.startPage(pn, 5);
        List<User> users = userService.findAll();
        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(users, 5);
        model.addAttribute("pageInfo", page);
        return "user";
    }


}
