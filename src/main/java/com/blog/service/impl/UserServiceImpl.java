package com.blog.service.impl;


import com.blog.Mapper.PrivilegeMapper;
import com.blog.Mapper.UserMapper;
import com.blog.model.User;
import com.blog.model.UserPrivilege;
import com.blog.service.UserService;
import com.blog.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public Map<String, String> register(String username, String password,String email) {
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isBlank(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }
        User user = userMapper.getUserByName(username);
        if (user != null) {
            map.put("msg", "用户名已经被注册");
            return map;
        }
        user = new User();
        user.setUserName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        user.setPassword(MD5Util.getMD5(password + user.getSalt()));
        user.setEmail(email);
        insertUser(user);
        UserPrivilege userPrivilege = new UserPrivilege(getId(username), "CommonUser");
        privilegeMapper.addPrivilege(userPrivilege);
        map.put("success", "注册成功");
        return map;
    }

    @Override
    public Map<String, String >login(String username, String password) {
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isBlank(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }
        User user = userMapper.getUserByName(username);

        if (user == null) {
            map.put("msg", "用户名不存在");
            return map;
        }
        if (!MD5Util.getMD5(password + user.getSalt()).equals(user.getPassword())) {
            map.put("msg", "密码不正确");
            return map;
        }
        map.put("success", "成功");
        return map;
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public String getPrivilege(String name) {
        return userMapper.getPrivilege(name);
    }

    @Override
    public int getId(String userName) {
        return userMapper.getId(userName);
    }

    @Override
    public void insertUser(User user) {
        user.setCreated(new Date());
        userMapper.addUser(user);
    }

    /**
     * 更新用户
     */
    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 根据Id删除用户
     */
    @Override
    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    /**
     * 根据id查找用户
     */
    @Override
    public User findUserById(int id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    /**
     * 查询所有用户
     */
    @Override
    public List<User> findAll() {
        List<User> allUser = userMapper.findAll();
        return allUser;
    }

}
