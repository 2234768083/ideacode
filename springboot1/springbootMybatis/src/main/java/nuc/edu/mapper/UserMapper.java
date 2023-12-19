package nuc.edu.mapper;

import io.swagger.models.auth.In;
import nuc.edu.pojo.User;
import nuc.edu.pojo.UserCustomer;
import nuc.edu.pojo.UserQueryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

//指定這是一個操作數據庫的mapper
//@Mapper
public interface UserMapper {
   /* //测试驼峰表示法，如果User表中的username属性修改为user_name，则此查询无法找到user_name的值，因为默认使用username
    //解决方法：创建MyBatisConfig类

    //@Select("select * from user where id=#{id}")
    User findUserById(Integer id);*/
    User findById(Integer id);
    List<User> findAllUser();
}
