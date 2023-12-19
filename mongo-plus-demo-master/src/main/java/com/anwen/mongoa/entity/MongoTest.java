/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.entity;

import com.anwen.mongo.annotation.ID;
import com.anwen.mongo.annotation.collection.CollectionName;
import com.anwen.mongo.enums.IdTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author JiaChaoYang
 * @project saas-service-file
 * @description
 * @date 2023-07-18 15:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@CollectionName("mongoTest")
public class MongoTest {

    @ID(type = IdTypeEnum.AUTO)
    private String id;

    private String userName;

    private Long role;

    private LocalDateTime createTime;

    private String userAddress;

    private Long userStatus;

}
