/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.service.impl;

import com.anwen.mongo.mapper.MongoPlusBeanMapper;
import com.anwen.mongo.mapper.MongoPlusMapMapper;
import com.anwen.mongo.service.impl.ServiceImpl;
import com.anwen.mongoa.entity.MongoTest;
import com.anwen.mongoa.entity.User;
import com.anwen.mongoa.service.MongoService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author JiaChaoYang
 * @project mongo-plus-demo
 * @description
 * @date 2023-07-18 22:27
 **/
@Service
public class MongoServiceImpl extends ServiceImpl<MongoTest> implements MongoService {

}
