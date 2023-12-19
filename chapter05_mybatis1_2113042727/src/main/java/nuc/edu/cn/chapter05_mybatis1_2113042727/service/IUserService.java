package nuc.edu.cn.chapter05_mybatis1_2113042727.service;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.User;

import java.util.List;

public interface IUserService {
    public User getUser(Integer id);
    public List<User> findAllUser();
    public List<User> findUsers(String userName, String note);
    public Integer insertUser(User user);
    public Integer deleteUser(Integer id);
    public Integer updateUser(User user);
}