package com.blog.model;
/**
 * author bebetter159
 */
public class UserPrivilege  {
    private  int id;
    private  String privilege;

    public UserPrivilege(){super(); }
    public UserPrivilege(int id,String privilege){
        super();
        this.id=id;
        this.privilege=privilege;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }



}
