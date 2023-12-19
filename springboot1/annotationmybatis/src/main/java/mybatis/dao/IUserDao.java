package mybatis.dao;


import mybatis.Entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author hongjun
 * @create 2020-10-28 17:27
 */
@Mapper
public interface IUserDao {

    /*
    * 查询所有用户信息
    * */
    @Select("select * from user")
    @Results(id ="userMap",value =
            {       @Result(id = true,column = "id" ,property="userId"),
                    @Result(column = "username" ,property="userName"),
                    @Result(column = "sex" ,property="sex"),
                    @Result(column = "birthday" ,property="birthday"),
                    @Result(column = "address" ,property="address"),
                    @Result(column = "id", property = "ordersList",many = @Many(select = "mybatis.dao.IOrdersDao.findOrderById",fetchType = FetchType.LAZY))
            } )
    List<User> findAll();
    @Delete("delete from user where id=#{id}")
    int deleteUserById(Integer id);
    @Options(useGeneratedKeys = true, keyProperty = "id")
     @Insert("insert into user(username,birthday,sex,address) values(#{userName},#{birthday},#{sex},#{address})")
    int insertUser(User user);
    @Update("update user set username=#{userName},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    int updateUser(User user);
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String name);
    @Select({"select * from user where id=#{id}"})
    @ResultMap("userMap")
    User findUserById(Integer id);
}
