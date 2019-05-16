package com.zzc.paramtest.param;

/**
 * @author zhaoZhengchang
 * @create_date 2018-12-10 14:31
 * Description:
 **/

public class User {

    private String  id ;
    private String  name ;
    private Role  role ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
