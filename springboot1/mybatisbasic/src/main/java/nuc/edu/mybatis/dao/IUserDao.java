package nuc.edu.mybatis.dao;

import nuc.edu.mybatis.Entity.User;

import java.util.List;

/**
 * @author hongjun
 * @create 2020-10-28 17:27
 */
public interface IUserDao {

    /*
    * 查询所有用户信息
    * */
    List<User> findAll();
}
