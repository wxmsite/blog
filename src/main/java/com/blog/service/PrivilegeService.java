package com.blog.service;


import com.blog.model.UserPrivilege;
import org.springframework.stereotype.Service;


public interface PrivilegeService {
     void addPrivilege(UserPrivilege userPrivilege);
     boolean updatePrivilege(UserPrivilege userPrivilege);
}
