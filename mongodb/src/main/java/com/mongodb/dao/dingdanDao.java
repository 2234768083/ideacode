package com.mongodb.dao;

import com.mongodb.pojo.LogBean;
import com.mongodb.pojo.Logistics;
import com.mongodb.pojo.dingdan;
import com.mongodb.pojo.historyorder;

import java.util.List;

/**
 * 订单数据访问对象接口
 */
public interface dingdanDao {
    // 添加订单
    void addorder(dingdan dingdan);

    // 添加物流日志信息并更新订单状态
    void addLogisticsAndUpdateStatus(Logistics logistics);

    // 添加日志信息：记录方法、请求名称、IP信息等
    void addLogs(LogBean logBean);

    // 根据ID查找订单
    dingdan getOrderById(int id);

    // 根据ID删除订单
    boolean deleteOrderById(int id);

    // 展示所有订单信息
    List<dingdan> getAllorder();

    // 获取所有历史订单
    List<historyorder> getAllHistoryorder();

    // 根据ID获取历史订单信息
    historyorder getHistoryorderById(int id);

    // 修改订单信息
    void editOrder(int id, String recevier, String recevierAddress, long receviePhone);
}
