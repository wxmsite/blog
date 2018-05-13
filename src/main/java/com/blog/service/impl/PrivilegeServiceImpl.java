package com.blog.service.impl;

import com.blog.model.UserPrivilege;
import com.blog.service.PrivilegeService;
import com.blog.Mapper.PrivilegeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    /**
     * 注入privilegeMapper接口
     */
    @Autowired
    PrivilegeMapper privilegeMapper;
    @Override
    public void addPrivilege(UserPrivilege userPrivilege) {
        privilegeMapper.addPrivilege(userPrivilege);
    }

    @Override
    public boolean updatePrivilege(UserPrivilege userPrivilege) {
        return privilegeMapper.updatePrivilege(userPrivilege);
    }
}
