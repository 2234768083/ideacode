package com.example.mongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private String id; //订单编号
    private String status; //订单状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderTime; //下单时间
    private String shoperName; //发货人姓名
    private String shoperAddress; //发货人的地址
    private String shoperPhon; //发货人电话
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date shoperTime;//发货时间
    private String recever; //收货人
    private String receverAddress; //收货人地址
    private String receverPhon; //收货人电话
    private List<Logistics> logistics; //物流信息

}
