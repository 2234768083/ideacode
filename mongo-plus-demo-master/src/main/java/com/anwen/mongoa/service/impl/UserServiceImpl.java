/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.service.impl;

import com.anwen.mongo.conditions.query.QueryChainWrapper;
import com.anwen.mongo.execute.SqlExecute;
import com.anwen.mongo.service.impl.ServiceImpl;
import com.anwen.mongoa.entity.User;
import com.anwen.mongoa.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @BelongsProject: mongo-plus-demo
 * @BelongsPackage: com.anwen.mongo.service.impl
 * @Author: JiaChaoYang
 * @CreateTime: 2023-02-26 17:09
 * @Version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<User> implements UserService{

    @Override
    public User one(QueryChainWrapper<User, ?> queryChainWrapper) {
        SqlExecute sqlOperation = getSqlOperation();
        //TODO 自定义
        return super.one(queryChainWrapper);
    }
}
