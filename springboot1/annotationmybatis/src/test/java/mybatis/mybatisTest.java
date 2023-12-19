package mybatis;

import cn.hutool.Hutool;
import mybatis.Entity.Orders;
import mybatis.Entity.User;
import mybatis.dao.IOrdersDao;
import mybatis.dao.IUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author hongjun
 * @create 2020-05-02 17:20
 */
@SpringBootTest
public class mybatisTest {
    @Autowired
    IUserDao userDao;
    @Autowired
    IOrdersDao ordersDao;
    @Test
    public void TestFindAllUser(){
        List<User> allUser = userDao.findAll();
        for (User user:allUser
             ) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testinsertUser(){
       User user=new User();
       user.setUserName("hongjun");
       user.setAddress("中北大学");
       user.setBirthday(new Date());
        user.setSex("男");
       userDao.insertUser(user);
    }
 /*   @Test
    public void TestUpdateUserbyId(){
        User user=new User();
        user.setUserName("wxj");
        user.setId(28);
        userDao.updateUser(user);
    }*/
    @Test
    public void TestDeleteUserbyId(){
        userDao.deleteUserById(28);
    }
    @Test
    public void TestFindUserByName(){
        List<User> userList = userDao.findUserByName("%张%");
        for (User user :
                userList) {
            System.out.println(user);
        }
    }
    @Test
    public void TestFindUserbyId(){
        User user = userDao.findUserById(27);
        System.out.println(user);
    }
    @Test
    public void testFindAllOrders(){
        List<Orders> orderUser = ordersDao.findOrderUser();
        for (Orders order:orderUser
             ) {
            System.out.println(order);
            System.out.println(order.getUser());
        }

    }
    @Test
    public void testFindAllUsers(){
        List<User> userList = userDao.findAll();
        for (User user:userList
        ) {
            System.out.println(user);
           // System.out.println(user.getOrdersList());
        }

    }
}
