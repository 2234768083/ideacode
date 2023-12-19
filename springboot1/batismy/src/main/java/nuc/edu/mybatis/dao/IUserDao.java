package nuc.edu.mybatis.dao;

import nuc.edu.mybatis.Entity.User;
import nuc.edu.mybatis.Entity.UserC;
import nuc.edu.mybatis.Entity.queryVO;

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
    /*
    * 插入用户信息
    * */
    void insertUser(User user);

    /*
    * 更新用户数据
    *
    * */
    void updateUser(User user);


    /*
    * 删除用户
    * */
    void deleteUserById(Integer id);
/*
* 根据id查询用户信息
*
* */
    User findUserById(Integer id);
    /*
    * 根据姓名查询用户信息
    * */
    List<User> findUserByName(String username);

    /*
    * 查询统计数据
    * */
    int totalCount();

    /*
    * 包装类查询
    * */
    List<User> findUserList(queryVO queryVO);
    /*
    * 字段名不匹配测试
    * */
    List<UserC> findAllUserC();

    /*
    * 根据传入的条件进行查询,查询条件不固定，例如姓名、性别、或其他
    * */
    List<User> findUserByCondition(User user);
    /*
    * 查询指定范围内数据
    * */
    List<User> findUserinIds(queryVO vo);

}
