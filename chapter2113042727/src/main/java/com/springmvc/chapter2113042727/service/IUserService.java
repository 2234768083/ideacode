package com.springmvc.chapter2113042727.service;

import com.springmvc.chapter2113042727.pojo.User;

import java.util.List;

//public interface IUserService {
//    public User getUser(Integer id);
//}
public interface IUserService {
    public User getUser(Integer id);
    public List<User> findAllUser();
    public Boolean insertUser(User user);
}
