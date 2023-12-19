package nuc.edu.controller;
/**
 * author:hongjun
 */

import nuc.edu.mapper.OrdersMapper;
import nuc.edu.pojo.Orders;
import nuc.edu.pojo.User;
import nuc.edu.pojo.UserCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    OrdersMapper ordersMapper;
    @RequestMapping("findOrderById/{id}")
    public Orders findOrderById(@PathVariable("id") Integer id){
        System.out.println("查询订单信息！");
        return  ordersMapper.findOrderById(id);
    }
    @RequestMapping("insert")
    public Orders insertOder(Orders orders){
        ordersMapper.insertOrder(orders);
        return  orders;
    }
    @RequestMapping("findorderbyname")
    public List<Orders> findOrderByName(@RequestParam("name") String name){
        System.out.println("模糊查询执行中！");
        List<Orders> ordersList=ordersMapper.findOrderByName(name);
        return ordersList;
    }
    @GetMapping("findOrderUser")
    public List<Orders> findOrderUser(){

        List<Orders> ordersList= ordersMapper.findOrderUser();

        return ordersList;
    }
   /* @GetMapping("findOrdersUserResultMap")
    public  List<Orders> findOrdersUserResultMap(){

        return ordersMapper.findOrdersUserResultMap();
    }*/
    @GetMapping("findOrdersAndOrderDetailResultMap")
    public List<Orders> findOrdersAndOrderDetailResultMap(){

        List<Orders> ordersList= ordersMapper.findOrdersAndOrderDetailResultMap();
        System.out.println(ordersList);
        return ordersList;
    }
    @GetMapping("findUserAndItemsResultMap")
    public List<User> findUserAndItemsResultMap()
    {
        return ordersMapper.findUserAndItemsResultMap();
    }
    @GetMapping("lazyloading")
    public void findOrdersUserLazyLoading(){
        List<Orders> ordersList= ordersMapper.findOrdersUserLazyLoading();
        for(Orders orders: ordersList){
            User user=orders.getUser();
            System.out.println(user.toString());
        }
    }
}
