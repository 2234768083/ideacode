/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.entity;

import com.anwen.mongo.annotation.ID;
import com.anwen.mongo.annotation.collection.CollectionField;
import com.anwen.mongo.annotation.collection.CollectionName;
import com.anwen.mongo.enums.IdTypeEnum;
import com.anwen.mongo.model.BaseModelID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @BelongsProject: mongo-plus-demo
 * @BelongsPackage: com.anwen.mongo
 * @Author: JiaChaoYang
 * @CreateTime: 2023-02-26 19:08
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@CollectionName("test")
public class Role {

    @ID
    private String id;

    private String name;

    private Integer age;

    @CollectionField(value = "roleaaaaa",convertCollect = true)
    private T t;
}

