package com.zzc.paramtest.param;

/**
 * @author zhaoZhengchang
 * @create_date 2018-12-10 14:31
 * Description:
 **/

public class Role {

    private String  id ;
    private String  name ;

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

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
