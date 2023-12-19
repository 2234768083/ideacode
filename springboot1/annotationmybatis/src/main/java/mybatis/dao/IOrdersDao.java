package mybatis.dao;

import mybatis.Entity.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

//@Mapper或者@MapperScan将接口装配到容器中，入口程序已经设置
@Mapper
public interface IOrdersDao {

//一对一查询
@Select("select * from orders")
@Results(value = {
        @Result(column = "user_id",property = "user",one = @One(select = "mybatis.dao.IUserDao.findUserById",fetchType = FetchType.LAZY))
})
public List<Orders> findOrderUser();
@Select("select * from orders where user_id=#{id}")
public Orders findOrderById(Integer id);
}
