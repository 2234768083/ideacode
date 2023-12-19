package com.example.mongodb.controller;

import com.example.mongodb.entity.Logistics;
import com.example.mongodb.entity.Order;
import com.example.mongodb.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 订单con
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     *    添加订单
     */
    @PostMapping("add")
    public String addOrder(Order order){
        orderService.addOrder(order);
        return "订单添加成功";
    }

    /**
     * 更新订单状态
     * @param logistics
     * @return
     */
    @PostMapping("update")
    public String updateOrderAddLogistics(Logistics logistics){
        orderService.updateOrderAddLogistics(logistics);
        return "物流添加成功";
    }

    /**
     * 通过ID查询订单
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Order selectOrderByID(@PathVariable String id){

        return orderService.selectOrderByID(id);
    }
    /**
     *查询所有订单
     */
    @GetMapping("list")
    public Map<String , Object> selectOrderList(){

        return orderService.selectOrderList();
    }
    /**
     *删除订单
     */
    @PostMapping("delete")
    public String deleteById(String id) {
        orderService.deleteOerderById(id);
        return "删除成功！";
    }



}
