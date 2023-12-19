package nuc.edu.mapper;

import nuc.edu.pojo.Orders;
import nuc.edu.pojo.User;
import nuc.edu.pojo.UserCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

//@Mapper或者@MapperScan将接口装配到容器中，入口程序已经设置
@Mapper
public interface OrdersMapper {
public List<Orders> findOrderByName(String name);
public void insertOrder(Orders orders);
public void deleteOrder(Integer id);
public Orders updateOrder(Orders orders);
//一对一查询

public List<Orders> findOrderUser();
//ResultMap一对一查询
//public List<Orders> findOrdersUserResultMap();
//ResultMap一对多查询
public List<Orders> findOrdersAndOrderDetailResultMap();
//ResultMap多对多查询
public List<User> findUserAndItemsResultMap();
public List<Orders> findOrdersUserLazyLoading();
//Orders findOrderId(Integer id);
public  Orders findOrderById(Integer id);
}
