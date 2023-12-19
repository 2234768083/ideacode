/*
 * Copyright (c) JiaChaoYang 2023-11-21 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.config;

import com.anwen.mongo.handlers.MetaObjectHandler;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author JiaChaoYang
 **/
@Component
public class MongoPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(Map<String, Object> insertFillMap, Document document) {
        insertFillMap.keySet().forEach(key -> {
            if (key.equals("createTime")){
                document.put(key, LocalDateTime.now());
            }
        });
    }

    @Override
    public void updateFill(Map<String, Object> insertFillMap, Document document) {
        insertFillMap.keySet().forEach(key -> {
            if (key.equals("createTime")){
                document.put(key, LocalDateTime.now());
            }
        });
    }
}
