package com.example.mongodb.controller;

import com.example.mongodb.entity.User;
import com.example.mongodb.service.ShoppingCarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("car")
public class ShoppingCarController {

    @Resource
    ShoppingCarService shoppingCarService;
    /**
     * 根据用户ID查询购物车
     */
    @GetMapping ("{id}")
    public User selectCarByID(@PathVariable String id){
        return shoppingCarService.selectCarByID(id);
    }
    /**
     *查询所有购物车
     */
    @GetMapping("list")
    public Map<String , Object> selectOrderList(){

        return shoppingCarService.selectCarList();
    }

    /**
     * 清空购物车
     */
    @GetMapping("clear/{uid}")
    public String ClearCarById(@PathVariable String uid){
        shoppingCarService.ClearCarById(uid);
        return "删除成功！";
    }

}
