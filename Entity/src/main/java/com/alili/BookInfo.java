package com.alili;

public class BookInfo {
    private String id;

    public BookInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public  BookInfo(){

    }
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

    private   String name;
}
