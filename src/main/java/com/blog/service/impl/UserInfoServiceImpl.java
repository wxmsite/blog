package com.blog.service.impl;


import com.blog.Mapper.UserInfoMapper;
import com.blog.model.UserInfo;
import com.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    /**
     * 注入UserMapper接口
     */
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo getUserByName(String name) {
        return userInfoMapper.getUserByName(name);
    }

    @Override
    public String getPrivilege(String name) {
        return userInfoMapper.getPrivilege(name);
    }

    @Override
    public int getId(UserInfo userInfo) {
        return  userInfoMapper.getId(userInfo);
    }

    /**
     * 新增用户
     */
    @Override
    public void addUser(UserInfo userInfo) {

        userInfo.setCreated(new Date());
        userInfoMapper.addUser(userInfo);
    }

    /**
     * 更新用户
     */
    @Override
    public boolean updateUser(UserInfo userInfo) {
        return userInfoMapper.updateUser(userInfo);
    }

    /**
     * 根据Id删除用户
     */
    @Override
    public boolean deleteUser(int id) {
        return userInfoMapper.deleteUser(id);
    }

    /**
     * 根据id查找用户
     */
    @Override
    public UserInfo findUserById(int id) {
        UserInfo userInfo = userInfoMapper.findUserById(id);
        return userInfo;
    }

    /**
     * 查询所有用户
     */
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> allUserInfo = userInfoMapper.findAll();
        return allUserInfo;
    }

}
