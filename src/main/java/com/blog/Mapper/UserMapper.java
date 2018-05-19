package com.blog.Mapper;

import com.blog.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * author bebetter159
 * date  时间未详
 */
@Mapper
public interface UserMapper {
    User getUserByName(String username);
    String getPrivilege(String name);
    int getId(String userName);
    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);
    /**
      *更新用户数据
     * @param user
     * @return
     */
    boolean updateUser(User user);

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
    User findUserById(int id);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();
}
