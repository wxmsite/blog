package com.blog.service;

import com.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * author bebetter159
 * date  时间未详
 */
@Service
public interface UserService {
    Map<String, String> register(String username, String password,String email);

    Map<String, String> login(String username, String password);

    User getUserByName(String name);

    String getPrivilege(String name);

    int getId(String userName);
    void insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    User findUserById(int id);

    List<User> findAll();

}
