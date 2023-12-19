package com.mongodb.service.Impl;

import com.mongodb.config.MongoDBAppender;
import com.mongodb.dao.userDao;
import com.mongodb.pojo.LogBean;
import com.mongodb.pojo.UserExtendInfo;
import com.mongodb.pojo.user;
import com.mongodb.pojo.userall;
import com.mongodb.service.userService;
import com.mongodb.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    private static final Logger logger = LoggerFactory.getLogger(userServiceImpl.class);
    private static final Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static final Logger los = LoggerFactory.getLogger(MongoDBAppender.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    userDao userDao;

    /**
     * 重写父类方法，用于向数据库中添加用户信息
     *
     * @param user 要添加的用户对象
     */
    @Override
    public void adduser(user user) {

        userDao.adduser(user);
    }


    /**
     * 重写父类方法，用于向数据库中添加用户扩展信息
     *
     * @param userExtendInfo 用户扩展信息
     */
    @Override
    public void addexuser(UserExtendInfo userExtendInfo) {
        userDao.addexuser(userExtendInfo);
    }


    /**
     * 为日志Bean添加日志
     *
     * @param logBean 日志Bean对象
     */
    @Override
    public void addLogs(LogBean logBean) {
        userDao.addLogs(logBean);
    }


    /**
     * 根据用户ID获取用户信息
     *
     * @param id 用户ID
     * @return 用户对象
     */
    @Override
    public user getUserById(int id) {
        return userDao.getUserById(id);
    }


    /**
     * 根据用户ID获取用户扩展信息
     *
     * @param id 用户ID
     * @return 用户扩展信息
     */
    @Override
    public UserExtendInfo getUserexById(int id) {
        return userDao.getUserexById(id);
    }


    /**
     * 根据用户ID获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息(userall对象)
     */
    @Override
    public userall getUserallById(int id) {
        return userDao.getUserallById(id);
    }


    /**
     * 根据用户ID删除用户
     *
     * @param id 用户ID
     * @return 删除是否成功的布尔值
     */
    @Override
    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }


    /**
     * 获取所有用户信息
     *
     * @return 包含所有用户信息的列表
     */
    @Override
    public List<user> getAlluser() {
        return userDao.getAlluser();
    }


    /**
     * 获取所有用户扩展信息
     *
     * @return 所有用户扩展信息的列表
     */
    @Override
    public List<UserExtendInfo> getAllexuser() {
        return userDao.getAllexuser();
    }


    /**
     * 获取所有userall信息
     *
     * @return 所有userall信息的列表
     */
    @Override
    public List<userall> getAlluserall() {
        return userDao.getAlluserall();
    }


    /**
     * 修改用户信息
     *
     * @param id       用户ID
     * @param nickname 用户昵称
     * @param age      用户年龄
     * @param sex      用户性别
     */
    @Override
    public void editUser(int id, String nickname, int age, String sex) {
        userDao.editUser(id, nickname, age, sex);
    }


    /**
     * 修改用户信息
     *
     * @param id      用户ID
     * @param phone   用户电话号码
     * @param school  用户所在学校
     * @param address 用户地址
     */
    @Override
    public void editexUser(int id, String phone, String school, String address) {
        userDao.editexUser(id, phone, school, address);
    }

}
