package com.alili;

public class UserInfo {
    public String getId() {
        return id;
    }

    public  UserInfo(){

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

    private  String id;
    private  String name;
}
