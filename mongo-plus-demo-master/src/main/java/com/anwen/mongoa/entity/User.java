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
import com.anwen.mongo.enums.FieldFill;
import com.anwen.mongo.enums.IdTypeEnum;
import com.anwen.mongo.model.BaseModelID;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description:
 * @BelongsProject: mongo-plus-demo
 * @BelongsPackage: com.anwen.mongo.entity
 * @Author: JiaChaoYang
 * @CreateTime: 2023-02-26 16:54
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ID(type = IdTypeEnum.ASSIGN_ID,saveField = true)
    private String userId;

    @CollectionField("userName")
    private String userName;

//    @CollectionField(value = "userAddress")
    private String userAddress;

//    @CollectionField(exist = false)
    private Integer userAge;

    private Long userStatus;

//    @CollectionField(exist = false)
    private Role role;

    private List<B> aList;

    @CollectionField(value = "createTime",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    private Double slat;

}

