package nuc.edu;

import nuc.edu.mapper.OrdersMapper;
import nuc.edu.mapper.UserMapper;
import nuc.edu.pojo.Orders;
import nuc.edu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hongjun
 * @create 2020-11-16 8:03
 */
@SpringBootTest
public class MybatisApplicationTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    UserMapper userMapper;
    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    @Transactional
    public void testFindorderById(){
        Orders order1=ordersMapper.findOrderById(3);
        /*Orders order2=ordersMapper.findOrderById(3);
        System.out.println(order1==order2);*/
        System.out.println(order1.toString());
    }
    @Test
    public void testFindUserById(){
        User user = userMapper.findById(10);
        System.out.println(user.toString());

    }
    @Test
    public void testfindorderuser(){
        List<Orders> ordersList=ordersMapper.findOrderUser();
        for (Orders u:
             ordersList ) {
            System.out.println(u);
        }

    }
    @Test
    public void testlazyloading(){
        List<Orders> ordersUserList = ordersMapper.findOrdersUserLazyLoading();
        for (Orders order:ordersUserList){
            System.out.println(order);
            System.out.println(order.getUser());
        }
    }
    @Test
    public void testOnetoManylazyloading(){
        List<User> allUser = userMapper.findAllUser();
        for (User user:allUser
             ) {
            System.out.println(user);
            System.out.println(user.getOrdersList());
        }
    }
}
