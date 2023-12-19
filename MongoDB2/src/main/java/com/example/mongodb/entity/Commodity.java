package com.example.mongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 商品类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commodity {
    private String id; //商品编号
    private String name; //商品名称
    private Integer price; //商品价格
    private String firm; //发行公司
    private String profile; //商品简介
    private String type;//商品类别
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //购买时间
    private Date buyTime; //购买时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//上架时间
}
