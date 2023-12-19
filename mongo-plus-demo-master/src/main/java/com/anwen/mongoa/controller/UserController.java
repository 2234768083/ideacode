/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.anwen.mongo.annotation.MongoConversion;
import com.anwen.mongo.conditions.query.LambdaQueryChainWrapper;
import com.anwen.mongo.incrementer.id.IdWorker;
import com.anwen.mongo.mapper.MongoPlusMapMapper;
import com.anwen.mongo.model.PageResult;
import com.anwen.mongo.service.IService;
import com.anwen.mongo.service.impl.ServiceImpl;
import com.anwen.mongo.strategy.convert.ConversionService;
import com.anwen.mongo.strategy.convert.ConversionStrategy;
import com.anwen.mongoa.dto.UserDTO;
import com.anwen.mongoa.entity.*;
import com.anwen.mongoa.service.MongoService;
import com.anwen.mongoa.service.RoleService;
import com.anwen.mongoa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @BelongsProject: mongo-plus-demo
 * @BelongsPackage: com.anwen.mongo.controller
 * @Author: JiaChaoYang
 * @CreateTime: 2023-02-26 17:10
 * @Version: 1.0
 */
@RestController
@Slf4j
@Api(tags = "测试控制类")
public class UserController extends ServiceImpl<User> implements IService<User> {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private MongoPlusMapMapper mongoPlusOperate;

    @Resource
    private MongoTemplate mongoTemplate;

    @GetMapping("findAllRole")
    @ApiOperation("查询所有角色")
    public List<Role> findAllRole(@RequestParam(value = "roleName",required = false)String roleName){
        List<Role> roleList = roleService.lambdaQuery().eq(StringUtils.isNotBlank(roleName), Role::getName, roleName).orderByDesc(Role::getAge).list();
        return roleList;
    }

    @PostMapping("/addRole")
    @ApiOperation("添加角色")
    @Transactional
    public Boolean addRole(@RequestBody Role role){
        role.setId(String.valueOf(IdWorker.getId()));
        roleService.save(role);
        Role byId = roleService.getById(role.getId());
        System.out.println(JSONUtil.toJsonStr(byId));
        int i = 1/0;
        return roleService.save(role);
    }

    @GetMapping("/findAllUser")
    @ApiOperation("查询所有用户")
    public Object findAllUser(@RequestParam(value = "userName",required = false)String userName){

        long count = mongoService.count();


        LambdaQueryChainWrapper<User> lambdaQueryChainWrapper = userService.lambdaQuery().like(User::getUserName, "1").like(User::getUserName, "2");
        List<User> userList = userService.lambdaQuery().or(lambdaQueryChainWrapper).list();
        userList.forEach(System.out::println);




        System.out.println(count);
        return mongoService.page(1,10);
        /*long action = System.currentTimeMillis();
        log.info("mongoPlus开始时间：{}",action);
        List<Map<String, Object>> mapList = mongoPlusOperate.lambdaQuery().like("userName","英").list("user");
        long end = System.currentTimeMillis();
        log.info("mongoPlus结束时间：{}",end);
        log.error("耗时：{}",end-action);
        return mapList;*/
        /*List<User> userList = userService.lambdaQuery().or(userService.lambdaQuery().eq(User::getUserStatus, 1).eq(User::getUserName,"张三")).list();
        return userList;*/
//        return userService.lambdaQuery().like(StringUtils.isNotBlank(userName), User::getUserName, userName).gt(User::getUserStatus, 2).orderByAsc(User::getCreateTime).list();
    }

    @Resource
    private MongoService mongoService;

    @GetMapping("/findAllUser1111")
    @ApiOperation("查询所有用户")
    public Object findAllUser1111(@RequestParam(value = "userName",required = false)String userName){
//        return userService.lambdaQuery().like(StringUtils.isNotBlank(userName), User::getUserName, userName).orderByAsc(User::getCreateTime).list();
        return userService.lambdaAggregate().skip(1).limit(10).list();
    }

    @GetMapping("/lambdaUpdateUser")
    @ApiOperation("链式调用修改")
//    @MongoTransactional
    public Boolean lambdaUpdateUser(){
        boolean update = userService.lambdaUpdate().set(User::getUserStatus, 2).update();
        log.info("{}",update);
        throw new RuntimeException("asdf");
//        return ;
    }

    @GetMapping("/findAllUserByPage")
    @ApiOperation("分页查询所有用户")
    public PageResult<User> findAllUser(Integer pageNum, Integer pageSize, @RequestParam(value = "userName",required = false) String userName, @RequestParam(value = "roleName",required = false)String roleName){
        Map<Class<?>, ConversionStrategy<?>> allConversion = ConversionService.getAllConversion();
        LambdaQueryChainWrapper<User> queryChainWrapper = userService.lambdaQuery().like(StringUtils.isNotBlank(userName), User::getUserName, userName);
        queryChainWrapper.orderByDesc(User::getCreateTime);
        PageResult<User> page = userService.page(queryChainWrapper, pageNum, pageSize);
        User user = page.getContentData().get(0);
        page.getContentData().forEach(System.out::println);
        return page;
    }

    @Resource
    private MongoPlusMapMapper mongoPlusMapMapper;

    @PostMapping("/addUser")
    @ApiOperation("添加用户")
//    @Transactional
    public void addUser(@RequestBody User user){
//        String index = userService.createIndex(Indexes.text(User::getUserName));
//        System.out.println("索引名称："+index);
        List<Document> documentList = userService.listIndexes();
        documentList.forEach(System.out::println);
        user.setUserId(String.valueOf(new ObjectId()));
        Boolean save = userService.save(user);
        int i = 1 / 0;
        System.out.println(user);
    }

    /**
     * 实体转map
     * @author JiaChaoYang
     * @date 2023/11/6 16:26
     */
    private Map<String,Object> entityConversionMap(Object param){
        return entityConversionMap(param,String.class,Object.class);
    }

    private <K,V> Map<K,V> entityConversionMap(Object param,Class<K> keyClazz,Class<V> valueClazz){
        return JSON.parseObject(JSON.toJSONString(param),new TypeReference<Map<K,V>>(keyClazz,valueClazz){});
    }

    @Resource
    private MongoPlusMapMapper mapper;
    @PostMapping("/addA")
    @ApiOperation("添加用户")
    public void addUser(@RequestBody A a){
        A a1 = new A();
        B b = new B();
        b.setId(1L);
        a1.setId(2L);
        mongoTemplate.save(a1);
        List<A> all = mongoTemplate.findAll(A.class, "a");
        System.out.println(all);
    }

    @PostMapping("/addBatchUser")
    @ApiOperation("批量添加用户")
    public Object addBatchUser(@RequestBody UserDTO userDTO){
        return userService.saveBatch(userDTO.getUserList());
    }

    @PostMapping("/updateUserById")
    @ApiOperation("根据id修改用户")
    public Object updateUserById(@RequestBody User user){
        return userService.updateById(user);
    }

    @PostMapping("/updateBatchUserByIds")
    @ApiOperation("批量根据id修改用户")
    public Object updateBatchUserByIds(@RequestBody UserDTO userDTO){
        return userService.updateBatchByIds(userDTO.getUserList());
    }

    @PostMapping("/saveOrUpdateUser")
    @ApiOperation("添加或修改用户")
    public Object saveOrUpdateUser(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @PostMapping("/saveOrUpdateBatchUser")
    @ApiOperation("添加或修改多个用户")
    public Object saveOrUpdateBatchUser(@RequestBody UserDTO userDTO){
        return userService.saveOrUpdateBatch(userDTO.getUserList());
    }

    @GetMapping("/deleteUserById")
    @ApiOperation("根据id删除用户")
    public Object deleteUserById(@RequestParam("id")String id){
        return userService.getByColumn(User::getUserName,"张三12");
    }

//    @Override
//    public void convertValue(Field field, Object obj, Object fieldValue) throws IllegalAccessException {
//
//    }

/*    @PostMapping("/deleteUserByIds")
    @ApiOperation("根据ids删除用户")
    public Object deleteUserByIds(@RequestBody List<String> ids){
        return userService.removeBatchByIds(ids);
    }*/

}
