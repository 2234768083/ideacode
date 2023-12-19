package nuc.edu.cn.chapter05_mybatis1_2113042727.service.impl;

import nuc.edu.cn.chapter05_mybatis1_2113042727.dao.IUserDao;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.User;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userdao;
    @Override
    public User getUser(Integer id) {
// TODO Auto-generated method stub
        return userdao.getUser(id);
    }
    @Override
    public List<User> findAllUser() {
// TODO Auto-generated method stub
        return userdao.findAllUser();
    }
    @Override
    public List<User> findUsers(String userName, String note) {
// TODO Auto-generated method stub
        return userdao.findUsers(userName, note);
    }
    @Override
    public Integer insertUser(User user) {
// TODO Auto-generated method stub
        return userdao.insertUser(user);
    }
    @Override
    public Integer deleteUser(Integer id) {
// TODO Auto-generated method stub
        return userdao.deleteUser(id);
    }
    @Override
    public Integer updateUser(User user) {
// TODO Auto-generated method stub
        return userdao.updateUser(user);
    }
}