package com.example.mongodb.controller;


import com.example.mongodb.entity.User;
import com.example.mongodb.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户Con
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 添加用户
     * @param user
     */
    @PostMapping("adduser")
    public void addUser(User user){
        userService.addUser(user);
    }
    /**
     * 查询所有用户
     */
    @GetMapping("list")
    public Map<String , Object> selectCommodityList(){
        return userService.selectUserList();
    }

    /**
     * 删除用户
     */
    @PostMapping("delete")
    public String deleteUser(String id){
        userService.deleteUser(id);
        return "删除成功";
    }

}
