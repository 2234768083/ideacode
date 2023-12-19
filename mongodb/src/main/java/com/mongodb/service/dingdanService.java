package com.mongodb.service;

import com.mongodb.pojo.LogBean;
import com.mongodb.pojo.Logistics;
import com.mongodb.pojo.dingdan;
import com.mongodb.pojo.historyorder;

import java.util.List;

public interface dingdanService {
    //添加订单
    void addorder(dingdan dingdan);

    //添加物流日志信息
    void addLogisticsAndUpdateStatus(Logistics logistics);

    //添加日志信息：方法、请求名称、IP信息等
    void addLogs(LogBean logBean);

    //按照ID查找订单
    dingdan getOrderById(int id);

    //按照ID删除订单
    boolean deleteOrderById(int id);

    //展示所有订单信息
    List<dingdan> getAllorder();

    //历史订单
    List<historyorder> getAllHistoryorder();

    //按ID查找历史订单信息
    historyorder getHistoryorderById(int id);

    //修改订单信息
    void editOrder(int id, String recevier, String recevierAddress, long receviePhone);
}
