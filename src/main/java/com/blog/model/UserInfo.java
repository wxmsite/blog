package com.blog.model;

import java.util.Date;

public class UserInfo {

    //主键
    private int id;
    //用户名
    private String username;
    //密码
    private String password;
    private String email;
    private Date Created;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Created=" + Created +
                ", userPrivilege=" + userPrivilege +
                '}';
    }


    public UserInfo(String username, String password ,Date created) {
        this.username = username;
        this.password = password;

        Created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }

    private UserPrivilege userPrivilege;

    public UserInfo() {
        super();
    }
    public UserInfo(int id, String username, String password,UserPrivilege userPrivilege) {
        super();
        this.id = id;
        this.username = username;
        this.password=password;
        this.userPrivilege=userPrivilege;

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public UserPrivilege getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(UserPrivilege userPrivilege) {
        this.userPrivilege = userPrivilege;
    }



}