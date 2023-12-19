package com.springmvc.chapter2113042727.pojo;

public class User {
    private Integer id;
    private String userName;
    private String note;
    public User() {
        super();
    }
    public User(Integer i, String userName, String note) {
        super();
        this.id = i;
        this.userName = userName;
        this.note = note;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
