package com.example.mongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id; //编号
    private String name; //用户名字
    private String account; //用户账号
    private String password; //用户密码
    private String userPhon; //用户电话
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime; //创建时间
    private List<Commodity> commodity; //购物车
}
