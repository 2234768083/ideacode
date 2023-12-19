package nuc.edu.cn.chapter05_mybatis1_2113042727.dao;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserDao {
    public User getUser(Integer id);
    public List<User> findAllUser();
    public List<User> findUsers(
            @Param("userName") String userName,
            @Param("note") String note);

    public Integer insertUser(User user);
    public Integer deleteUser(Integer id);
    public Integer updateUser(User user);
}
