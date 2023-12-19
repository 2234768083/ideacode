package com.example.mongodb.service;

import com.example.mongodb.entity.Commodity;
import com.example.mongodb.entity.Order;
import com.example.mongodb.entity.User;
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
@RequestMapping("car")
public class ShoppingCarService {

    @Resource
    MongoTemplate mongoTemplate;
    /**
     * 通过用户编号查询购物车
     */
    public User selectCarByID(String id){
        //根据订单编号查询
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,User.class,"user");
    }

    /**
     *查询所有购物车
     */
    public Map<String ,Object> selectCarList(){
        List<User> list = mongoTemplate.findAll(User.class,"user");
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
     * 清空购物车
     */
    public void ClearCarById(String uid){
        //实例化Query
        Query query = new Query(Criteria.where("_id").is(uid));
        Update update = new Update();
        update.unset("commodity");
        //删除user表中的commodity字段
        mongoTemplate.upsert(query,update,User.class,"user");
    }


}
