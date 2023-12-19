package com.mongodb.log.impl;

import com.mongodb.log.logService;
import com.mongodb.pojo.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志服务实现类
 */
@Service
public class logServiceImpl implements logService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    com.mongodb.log.logDao logDao;

    /**
     * 查询所有日志
     *
     * @return 包含所有日志的列表
     */
    @Override
    public List<LogBean> findlog() {
        return logDao.findlog();
    }
}
