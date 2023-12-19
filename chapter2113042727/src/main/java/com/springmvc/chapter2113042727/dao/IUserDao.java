package com.springmvc.chapter2113042727.dao;


import com.springmvc.chapter2113042727.pojo.User;

import java.util.List;

//public interface IUserDao {
//    public User getUser(Integer id);
//}
public interface IUserDao {
    public User getUser(Integer id);
    public Boolean insertUser(User user);
    public List<User> findAllUser();
}
