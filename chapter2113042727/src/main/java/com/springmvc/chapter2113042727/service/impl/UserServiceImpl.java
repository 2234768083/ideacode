package com.springmvc.chapter2113042727.service.impl;

import com.springmvc.chapter2113042727.dao.IUserDao;
import com.springmvc.chapter2113042727.pojo.User;
import com.springmvc.chapter2113042727.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public User getUser(Integer id) {
// TODO Auto-generated method stub
        return userDao.getUser(id);
    }
    @Override
    public Boolean insertUser(User user) {
// TODO Auto-generated method stub
        Boolean flag=false;
        System.out.println(user.getUserName()+">>"+user.getNote());
        flag=userDao.insertUser(user);
        return flag;
    }
    @Override
    public List<User> findAllUser() {
// TODO Auto-generated method stub
        return userDao.findAllUser();
    }
}
