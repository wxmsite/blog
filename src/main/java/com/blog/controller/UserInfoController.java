package com.blog.controller;

import com.blog.model.UserInfo;
import com.blog.model.UserPrivilege;
import com.blog.service.PrivilegeService;
import com.blog.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserInfoController {
    private final UserInfoService userInfoService;
    private final PrivilegeService privilegeService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService, PrivilegeService privilegeService) {
        this.userInfoService = userInfoService;
        this.privilegeService = privilegeService;
    }

    /**
     * 跳转到添加用户界面
     * @return
     */
    @RequestMapping("toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    /**
     * 添加用户并重定向
     * @param model
     * @param userInfo
     * @return
     */
    @RequestMapping("addUser")
    public String addUser(Model model, UserInfo userInfo){

        UserInfo user=userInfoService.getUserByName(userInfo.getUsername());

        if(user == null){
          /*  String hashAlgorithmName = "MD5";
            int hashIterations = 2;
            Object obj = new SimpleHash(hashAlgorithmName, userInfo.getPassword(), null, hashIterations);
            userInfo.setPassword((String) obj);*/
            userInfoService.addUser(userInfo);
            UserPrivilege userPrivilege=new UserPrivilege(userInfoService.getId(userInfo),"Admin");
            privilegeService.addPrivilege(userPrivilege);
        }

        return "redirect:/user/userInfo";
    }


    /**
     * 更新用户数据
     * @param model
     * @param userInfo
     * @return
     */
    @RequestMapping("updateUser")
    public String UpdateUser(Model model,UserInfo userInfo){
        //更新user表和privilege表
        if(userInfoService.updateUser(userInfo)&&privilegeService.updatePrivilege(userInfo.getUserPrivilege())){
            userInfo = userInfoService.findUserById(userInfo.getId());
            model.addAttribute("user", userInfo);
            return "redirect:/user/userInfo";
        }
        return "/error";
    }

    /**
     * 获取所有用户数据
     * @param model
     * @return
     */
    @RequestMapping("getAllUser")
    public String getAllUser(Model model){
        List<UserInfo> userInfo = userInfoService.findAll();
        model.addAttribute("userList", userInfo);
        return "allUser";
    }

    /**
     * 查询用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(int id,Model model){
        model.addAttribute("user", userInfoService.findUserById(id));
        return "editUser";
    }

    /**
     * 根据id删除用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/delUser")
    public String deleteUser(int id,Model model){
        model.addAttribute("user", userInfoService.deleteUser(id));
        return "redirect:/user/userInfo";
    }

    /**
     * 分页查询用户
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping( "userInfo")
    public String getUsers(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model){
        //从第一条开始 每页查询五条数据
        PageHelper.startPage(pn, 5);
        List<UserInfo> userInfos = userInfoService.findAll();
        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(userInfos,5);
        model.addAttribute("pageInfo", page);
        return "allUser";
    }
    @RequestMapping("register")
    public String register (Model model){
        return "register";
    }

}
