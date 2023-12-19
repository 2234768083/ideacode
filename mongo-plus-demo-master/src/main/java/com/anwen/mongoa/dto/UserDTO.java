/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.dto;

import com.anwen.mongoa.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @BelongsProject: mongo-plus-demo
 * @BelongsPackage: com.anwen.mongo.dto
 * @Author: JiaChaoYang
 * @CreateTime: 2023-02-26 17:32
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private List<User> userList;

}
