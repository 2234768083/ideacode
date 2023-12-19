/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa;

import com.anwen.mongo.mapper.MongoPlusMapMapper;
import com.anwen.mongo.model.GroupField;
import com.anwen.mongoa.entity.User;
import com.anwen.mongoa.service.RoleService;
import com.anwen.mongoa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author JiaChaoYang
 **/
@SpringBootTest
public class TTT{

    @Resource
    private UserService userService;

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private RoleService roleService;

    @Resource
    private MongoPlusMapMapper mongoPlusMapMapper;

    @Test
//    @MongoTransactional
    public void m(){
        User user = userService.getById(7);
        System.out.println(user);

//        List<User> userList = userService.lambdaQuery().eq(User::getUserId, 1).list();
//        userList.forEach(System.out::println);
//        Boolean save = mongoPlusMapMapper.save("codecTest", );
//        System.out.println(save);
        /*List<Role> roleList = roleService.lambdaAggregate().group(Role::getName).list();
        roleList.forEach(System.out::println);*/
        /*Role role = roleService.lambdaQuery().orderByDesc(Role::getAge).one();
        System.out.println(role);*/
        /*boolean update = roleService.lambdaUpdate().set(Role::getName, "超级管理员").eq(Role::getId, 1699432824774127617L).remove();
        System.out.println(update);*/
//        Role role = new Role();
//        role.setName("超级管理员");
//        role.setAge(19);
//        T t = new T();
//        t.setRoleName("角色内部名称");
//        t.setRoleStatus(1);
//        role.setRole(t);
//        roleService.save(role);
//        List<Map<String, Object>> mapList = mongoPlusMapMapper.lambdaAggregate().match(new InjectWrapper().like("name", "角色")).allowDiskUse(true).list("test");
//        List<Role> roleList = roleService.lambdaAggregate().match(new Wrapper<Role>().like(Role::getName, "角色")).allowDiskUse(true).list();
//        System.out.println(mapList.get(0));
//        List<User> roleList = userService.lambdaQuery().eq(User::getUserStatus,1).list();
//        List<Map<String, Object>> mapList = mongoPlusMapMapper.list("test");
//        System.out.println(JSONUtil.toJsonStr(roleList));
//        roleService.save(new Role());
//        InjectAggregateWrapper injectAggregateWrapper = new InjectAggregateWrapper();
//        List<Map<String, Object>> mapList = mongoPlusMapMapper.aggregateList("test", injectAggregateWrapper.match(mongoPlusMapMapper.lambdaQuery().eq("name", "超级管理员")));
//        System.out.println(JSONUtil.toJsonStr(mapList));
//        List<Map<String, Object>> mapList = mongoPlusMapMapper.lambdaAggregate().match(mongoPlusMapMapper.lambdaQuery().eq("name", "超级管理员")).list("test");
//        List<Role> roleList = roleService.lambdaAggregateChain().replaceRoot(true,Role::getRole).list();
//        System.out.println(JSONUtil.toJsonStr(roleList));
    }

}
