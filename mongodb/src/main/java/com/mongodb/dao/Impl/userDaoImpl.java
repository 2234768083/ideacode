package com.mongodb.dao.Impl;

import com.mongodb.config.MongoDBAppender;
import com.mongodb.dao.userDao;
import com.mongodb.pojo.LogBean;
import com.mongodb.pojo.UserExtendInfo;
import com.mongodb.pojo.user;
import com.mongodb.pojo.userall;
import com.mongodb.service.Impl.userServiceImpl;
import com.mongodb.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据访问对象实现类
 */
@Repository
public class userDaoImpl implements userDao {

    private static final Logger logger = LoggerFactory.getLogger(userServiceImpl.class);
    private static final Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static final Logger los = LoggerFactory.getLogger(MongoDBAppender.class);

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 添加用户基本信息
     */
    @Override
    public void adduser(user user) {
        mongoTemplate.insert(user, "user");
    }

    /**
     * 添加用户拓展信息
     */
    @Override
    public void addexuser(UserExtendInfo userExtendInfo) {
        user user = new user();
        Query query = new Query(Criteria.where("_id").is(userExtendInfo.getId()));
        Update update = new Update();
        update.set("codeNum", userExtendInfo.getCodeNum());
        update.set("phone", userExtendInfo.getPhone());
        update.set("school", userExtendInfo.getSchool());
        update.set("address", userExtendInfo.getAddress());
        update.push("user", user);
        mongoTemplate.upsert(query, update, user.class);
    }

    /**
     * 添加日志信息
     */
    @Override
    public void addLogs(LogBean logBean) {
        Query query = new Query(Criteria.where("_id").is(logBean.getId()));
        Update update = new Update();
        update.push("(LogBean", logBean);
        mongoTemplate.upsert(query, update, user.class);
    }

    /**
     * 根据用户ID获取用户基本信息
     */
    @Override
    public user getUserById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        user user = mongoTemplate.findOne(query, user.class);
        return user;
    }

    /**
     * 根据用户ID获取用户拓展信息
     */
    @Override
    public UserExtendInfo getUserexById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        UserExtendInfo user = mongoTemplate.findOne(query, UserExtendInfo.class, "user");
        return user;
    }

    /**
     * 根据用户ID获取用户全部信息
     */
    @Override
    public userall getUserallById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        userall user = mongoTemplate.findOne(query, userall.class, "user");
        return user;
    }

    /**
     * 根据用户ID删除用户信息
     */
    @Override
    public boolean deleteUserById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, userall.class, "user");
        return true;
    }

    /**
     * 获取所有用户基本信息
     */
    @Override
    public List<user> getAlluser() {
        List<user> list = mongoTemplate.findAll(user.class, "user");
        return list;
    }

    /**
     * 获取所有用户拓展信息
     */
    @Override
    public List<UserExtendInfo> getAllexuser() {
        List<UserExtendInfo> list = mongoTemplate.findAll(UserExtendInfo.class, "user");
        return list;
    }

    /**
     * 获取所有用户全部信息
     */
    @Override
    public List<userall> getAlluserall() {
        List<userall> list = mongoTemplate.findAll(userall.class, "user");
        return list;
    }

    /**
     * 修改用户基本信息
     */
    @Override
    public void editUser(int id, String nickname, int age, String sex) {
        user user = new user();
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("nickname", nickname);
        update.set("age", age);
        update.set("sex", sex);
        mongoTemplate.upsert(query, update, "user");
    }

    /**
     * 修改用户拓展信息
     */
    @Override
    public void editexUser(int id, String phone, String school, String address) {
        UserExtendInfo userExtendInfo = new UserExtendInfo();
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("phone", phone);
        update.set("school", school);
        update.set("address", address);
        mongoTemplate.upsert(query, update, "user");
    }
}
