package com.mongodb.dao.Impl;

import com.mongodb.config.MongoDBAppender;
import com.mongodb.dao.dingdanDao;
import com.mongodb.pojo.LogBean;
import com.mongodb.pojo.Logistics;
import com.mongodb.pojo.dingdan;
import com.mongodb.pojo.historyorder;
import com.mongodb.service.Impl.dingdanServiceImpl;
import com.mongodb.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单数据访问对象实现类
 */
@Repository
public class dingdanDaoImpl implements dingdanDao {
    private static final Logger logger = LoggerFactory.getLogger(dingdanServiceImpl.class);
    private static final Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static final Logger log = LoggerFactory.getLogger(MongoDBAppender.class);

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 添加订单信息
     */
    @Override
    public void addorder(dingdan dingdan) {
        mongoTemplate.insert(dingdan, "dingdan");
        mongoTemplate.insert(dingdan, "historyorder");
    }

    /**
     * 添加物流信息并更新订单状态
     */
    @Override
    public void addLogisticsAndUpdateStatus(Logistics logistics) {
        String status = logistics.getOperation();
        Query query = new Query(Criteria.where("_id").is(logistics.getOrderId()));
        Update update = new Update();
        update.set("status", status);//更新状态
        update.push("Logistics", logistics);
        mongoTemplate.upsert(query, update, dingdan.class);
        mongoTemplate.upsert(query, update, historyorder.class);
    }

    /**
     * 添加日志信息
     */
    @Override
    public void addLogs(LogBean logBean) {
        Query query = new Query(Criteria.where("_id").is(logBean.getId()));
        Update update = new Update();
        update.push("(LogBean", logBean);
        mongoTemplate.upsert(query, update, dingdan.class);
    }

    /**
     * 根据订单ID获取订单信息
     */
    @Override
    public dingdan getOrderById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        dingdan dingdan = mongoTemplate.findOne(query, dingdan.class);
        return dingdan;
    }

    /**
     * 根据订单ID删除订单信息
     */
    @Override
    public boolean deleteOrderById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, dingdan.class, "dingdan");
        return true;
    }

    /**
     * 获取所有订单信息
     */
    @Override
    public List<dingdan> getAllorder() {
        List<dingdan> list = mongoTemplate.findAll(dingdan.class, "dingdan");
        return list;
    }

    /**
     * 获取所有历史订单信息
     */
    @Override
    public List<historyorder> getAllHistoryorder() {
        List<historyorder> list = mongoTemplate.findAll(historyorder.class, "historyorder");
        return list;
    }

    /**
     * 根据订单ID获取历史订单信息
     */
    @Override
    public historyorder getHistoryorderById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        historyorder historyorder = mongoTemplate.findOne(query, historyorder.class);
        return historyorder;
    }

    /**
     * 修改订单信息
     */
    @Override
    public void editOrder(int id, String recevier, String recevierAddress, long receviePhone) {
        dingdan dingdan = new dingdan();
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("recevier", recevier);
        update.set("recevierAddress", recevierAddress);
        update.set("receviePhone", receviePhone);
        mongoTemplate.upsert(query, update, "dingdan");
    }
}
