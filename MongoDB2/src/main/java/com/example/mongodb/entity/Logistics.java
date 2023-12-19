package com.example.mongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 物流
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logistics implements Serializable {
    private String orderID; //订单编号
    private String operation; //操作名称
    private String operator; //操作员
    private String phone; //工作人员的电话
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operationTime; //操作时间
    private String address; //操作地址
    private String details; //详情信息
}
