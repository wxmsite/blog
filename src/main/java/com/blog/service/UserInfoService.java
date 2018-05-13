package com.blog.service;

import com.blog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserInfoService {
    UserInfo getUserByName(String name);
    String getPrivilege(String name);
    int getId(UserInfo userInfo);
    void addUser(UserInfo userInfo);

    boolean updateUser(UserInfo userInfo);

    boolean deleteUser(int id);

    UserInfo findUserById(int id);

    List<UserInfo> findAll();
}
