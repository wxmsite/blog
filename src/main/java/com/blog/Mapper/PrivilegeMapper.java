package com.blog.Mapper;


import com.blog.model.UserPrivilege;
import org.apache.ibatis.annotations.Mapper;
/**
 * author bebetter159
 * date  时间未详
 */
@Mapper
public interface PrivilegeMapper {


     void addPrivilege(UserPrivilege userPrivilege);
     boolean updatePrivilege(UserPrivilege userPrivilege);
}
