package com.mongodb.dao;

import com.mongodb.pojo.LogBean;
import com.mongodb.pojo.UserExtendInfo;
import com.mongodb.pojo.user;
import com.mongodb.pojo.userall;

import java.util.List;

/**
 * 用户数据访问对象接口
 */
public interface userDao {
    // 添加用户基本信息
    void adduser(user user);

    // 添加用户拓展信息
    void addexuser(UserExtendInfo userExtendInfo);

    // 添加日志信息：记录方法、请求名称、IP信息等
    void addLogs(LogBean logBean);

    // 根据ID查找用户（基本信息）
    user getUserById(int id);

    // 根据ID查找用户(拓展信息)
    UserExtendInfo getUserexById(int id);

    // 根据ID查找用户(全部信息)
    userall getUserallById(int id);

    // 根据ID删除用户信息
    boolean deleteUserById(int id);

    // 展示所有用户基本信息
    List<user> getAlluser();

    // 展示用户拓展信息
    List<UserExtendInfo> getAllexuser();

    // 展示用户所有信息
    List<userall> getAlluserall();

    // 修改用户基本信息
    void editUser(int id, String nickname, int age, String sex);

    // 修改用户拓展信息
    void editexUser(int id, String phone, String school, String address);
}
