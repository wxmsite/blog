package com.blog.Mapper;

import com.blog.model.UserInfo;
import com.blog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    UserInfo getUserByName(String username);
    String getPrivilege(String name);
    int getId(UserInfo userInfo);
    /**
     * 新增用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo);
    /**
      *更新用户数据
     * @param userInfo
     * @return
     */
    boolean updateUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUser(int id);

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    UserInfo findUserById(int id);

    /**
     * 查找所有用户
     * @return
     */
    List<UserInfo> findAll();
}
