package com.example.mongodb.service;

import cn.hutool.core.util.IdUtil;
import com.example.mongodb.entity.Commodity;
import com.example.mongodb.entity.Logistics;
import com.example.mongodb.entity.Order;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 商品service
 */
@Service
@RestController
@RequestMapping("commodity")
public class CommodityService {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 添加商品的方法
     */
    public void addCommodity(Commodity commodity){
        //商品编号用雪花算法随机生成
        commodity.setId(IdUtil.getSnowflake(1, 1).nextIdStr());
        //上架时间
        commodity.setCreateTime(new Date());
        mongoTemplate.insert(commodity,"commodity");
    }

    /**
     * 查询所有商品
     */
    public Map<String ,Object> selectCommodityList(){
        List<Commodity> list = mongoTemplate.findAll(Commodity.class,"commodity");
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
     * 根据ID查询商品,并插入到对应购物车
     */
    public void SelectByIdToCar(String cid,String uid){
        Query query = new Query(Criteria.where("_id").is(cid));
        Commodity commodity = mongoTemplate.findOne(query,Commodity.class,"commodity");
        commodity.setBuyTime(new Date());
        Query query1 = new Query(Criteria.where("_id").is(uid));
        Update update = new Update();
        update.push("commodity",commodity);
        mongoTemplate.upsert(query1,update,"user");
    }

    /**
     * 根据商品编号删除商品
     */
    public boolean deleteCommodityById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query,Commodity.class,"commodity");
        return result.getDeletedCount()>0? true:false;
    }

    /**
     * 通过编号商品查询
     */
    public Commodity selectCarByID(String cid){
        //根据商品编号查询
        Query query = new Query(Criteria.where("_id").is(cid));

        return mongoTemplate.findOne(query,Commodity.class,"commodity");
    }
    /**
     * 通过商品ID修改商品
     */
    public void  UpdateComById(String name,Integer price,String firm,String profile,String cid){
        Query query = new Query(Criteria.where("_id").is(cid));
        //修改内容集合
        Update update = new Update();
        update.set("name",name);
        update.set("price",price);
        update.set("firm",firm);
        update.set("profile",profile);
        mongoTemplate.upsert(query,update,Commodity.class,"commodity");

    }


}
