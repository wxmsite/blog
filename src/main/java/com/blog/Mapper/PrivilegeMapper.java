package com.blog.Mapper;


import com.blog.model.UserPrivilege;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrivilegeMapper {


     void addPrivilege(UserPrivilege userPrivilege);
     boolean updatePrivilege(UserPrivilege userPrivilege);
}
