package com.mongodb.service.Impl;

import com.mongodb.config.MongoDBAppender;
import com.mongodb.dao.dingdanDao;
import com.mongodb.pojo.LogBean;
import com.mongodb.pojo.Logistics;
import com.mongodb.pojo.historyorder;
import com.mongodb.pojo.dingdan;
import com.mongodb.service.dingdanService;
import com.mongodb.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单服务实现类
 */
@Service
public class dingdanServiceImpl implements dingdanService {
    private static final Logger logger = LoggerFactory.getLogger(dingdanServiceImpl.class);
    private static final Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static final Logger los = LoggerFactory.getLogger(MongoDBAppender.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    dingdanDao dingdanDao;

    /**
     * 创建订单
     *
     * @param dingdan 订单对象
     */
    public void addorder(dingdan dingdan) {
        dingdanDao.addorder(dingdan);
    }


    /**
     * 更新物流信息并修改订单状态
     *
     * @param logistics 物流信息对象
     */
    public void addLogisticsAndUpdateStatus(Logistics logistics) {
        dingdanDao.addLogisticsAndUpdateStatus(logistics);
    }


    /**
     * 向日志中添加日志记录
     *
     * @param logBean 日志 Bean 对象
     */
    @Override
    public void addLogs(LogBean logBean) {
        dingdanDao.addLogs(logBean);
    }


    /**
     * 根据订单ID删除订单记录
     *
     * @param id 订单ID
     * @return 删除是否成功
     */
    public dingdan getOrderById(int id) {
        return dingdanDao.getOrderById(id);
    }


    /**
     * 根据订单ID删除订单记录
     *
     * @param id 订单ID
     * @return 删除是否成功
     */
    public boolean deleteOrderById(int id) {
        return dingdanDao.deleteOrderById(id);
    }

    /**
     * 查询所有订单
     *
     * @return 包含所有订单的列表
     */
    public List<dingdan> getAllorder() {
        return dingdanDao.getAllorder();
    }

    /**
     * 查询所有历史订单
     *
     * @return 包含所有历史订单的列表
     */
    @Override
    public List<historyorder> getAllHistoryorder() {
        return dingdanDao.getAllHistoryorder();
    }

    /**
     * 通过ID查询历史订单信息
     *
     * @param id 订单ID
     * @return 历史订单对象
     */
    @Override
    public historyorder getHistoryorderById(int id) {
        return dingdanDao.getHistoryorderById(id);
    }

    /**
     * 修改订单信息
     *
     * @param id       订单ID
     * @param recevier 订单状态
     */
    @Override
    public void editOrder(int id, String recevier, String recevierAddress, long receviePhone) {
        dingdanDao.editOrder(id, recevier, recevierAddress, receviePhone);
    }

}
