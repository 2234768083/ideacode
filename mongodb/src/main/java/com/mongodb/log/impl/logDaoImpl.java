package com.mongodb.log.impl;

import com.mongodb.log.logDao;
import com.mongodb.pojo.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 日志数据访问实现类
 */
@Repository
public class logDaoImpl implements logDao {
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 查询所有日志
     *
     * @return 包含所有日志的列表
     */
    @Override
    public List<LogBean> findlog() {
        List<LogBean> list = mongoTemplate.findAll(LogBean.class, "logs");
        return list;
    }


}
