package com.example.mongodb.service;

import cn.hutool.core.util.IdUtil;
import com.example.mongodb.entity.User;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
@RequestMapping("user")
public class UserService {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 添加用户的方法
     */
    public void addUser(User user){
        //用户UID用雪花算法随机生成
        user.setId(IdUtil.getSnowflake(1, 1).nextIdStr());
        //注册
        user.setCreateTime(new Date());
        mongoTemplate.insert(user,"user");
    }

    /**
     *查询所有用户
     */
    public Map<String ,Object> selectUserList(){
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
     * 删除用户
     */
    public boolean deleteUser(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query,User.class,"user");
        return result.getDeletedCount()>0? true:false;
    }
}
