package com.springmvc.chapter2113042727.dao.impl;

import com.springmvc.chapter2113042727.dao.IUserDao;
import com.springmvc.chapter2113042727.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
//public class UserDaoImpl implements IUserDao {
//
//    private List<User> users = new ArrayList<User>();
//    public UserDaoImpl() {
//        super();
//        users.add(new User(1, "user_name_1", "note_1"));
//        users.add(new User(2, "user_name_2", "note_2"));
//        users.add(new User(3, "user_name_3", "note_3"));
//    }
//    @Override
//    public User getUser(Integer id) {
//// TODO Auto-generated method stub
//        for (User user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;
//    }
//}
@Repository
public class UserDaoImpl implements IUserDao {
    private List<User> users = new ArrayList<User>();

    public UserDaoImpl() {
        super();
        users.add(new User(1, "user_name_1", "note_1"));
        users.add(new User(2, "user_name_2", "note_2"));
        users.add(new User(3, "user_name_3", "note_3"));
    }

    @Override
    public User getUser(Integer id) {
// TODO Auto-generated method stub
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Boolean insertUser(User user) {
// TODO Auto-generated method stub
        Boolean flag = false;
        System.out.println(user.getUserName() + ">>" + user.getNote());
        users.add(user);
        flag = true;
        return flag;
    }

    @Override
    public List<User> findAllUser() {
// TODO Auto-generated method stub
        return users;
    }
}
