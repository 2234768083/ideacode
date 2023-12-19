package com.example.mongodb.service;

import cn.hutool.core.util.IdUtil;
import com.example.mongodb.entity.Logistics;
import com.example.mongodb.entity.Order;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.internal.bulk.DeleteRequest;
import lombok.var;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RestController
@RequestMapping("order")
public class OrderService {
    @Resource
    private MongoTemplate mongoTemplate;
    /**
     * 添加订单至mongoDB
     * @param order
     */
    public void addOrder(Order order) {
        //订单编号用雪花算法生成
        order.setId(IdUtil.getSnowflake(1, 1).nextIdStr());
        //订单状态
        order.setStatus("已下单");
        //设置下单时间为当前时间
        order.setOrderTime(new Date());
        //设置发货时间
        order.setShoperTime(new Date());
        //添加订单值mongodb
        mongoTemplate.insert(order,"order");
    }

    /**
     * 更新订单信息
     * @param logistics
     */
    public void updateOrderAddLogistics(Logistics logistics){
        //获取操作名称
        String status = logistics.getOperator();
        //设置操作时间
        logistics.setOperationTime(new Date());
        //初始化Query对象，根据订单编号查询
        Query query = new Query(Criteria.where("_id").is(logistics.getOrderID()));
        //初始化update对象
        Update update = new Update();
        //跟新订单状态
        update.set("status",status);
        //追加物流信息
        update.push("logistics",logistics);
        //更新订单信息
        mongoTemplate.upsert(query,update,Order.class,"order");

    }
    /**
     * 通过编号订单查询
     */
    public Order selectOrderByID(String id){
        //根据订单编号查询
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,Order.class,"order");
    }

    /**
     *查询所有订单
     */
    public Map<String ,Object> selectOrderList(){
        List<Order> list = mongoTemplate.findAll(Order.class,"order");
        Map<String ,Object> map = new HashMap<>();
        if (list == null || list.isEmpty()){
            map.put("code","400");
            map.put("message","没有相关订单信息！！");
        }else {
            map.put("code","0");
            map.put("count",list.size());
            map.put("data",list);
        }

        return map;
    }

    /**
     * 根据订单编号删除订单
     */
    public boolean deleteOerderById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query,Order.class,"order");
        return result.getDeletedCount()>0? true:false;
    }
}
