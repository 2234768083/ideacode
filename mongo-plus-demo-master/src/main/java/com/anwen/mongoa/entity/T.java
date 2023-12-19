/*
 * Copyright (c) JiaChaoYang 2023-8-6 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class T {
    private String roleName;

    private A aa;

    private Integer roleStatus;

    private Map<String,Object> test1Map;

    private Map<String,Object> testNullMap;

    private Map<String,B> testEntityNullMap;

    private Map<String,B> test2Map;

    private Map<String,B> test3Map;

    private Map<String,Object> test4Map;
}
