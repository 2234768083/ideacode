package nuc.edu.mybatis.dao;

import nuc.edu.mybatis.Entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author hongjun
 * @create 2020-11-01 9:49
 */
public class IUserDaoImpl  implements IUserDao{
    private SqlSessionFactory sqlSessionFactory;
    public IUserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }
    @Override
    public List<User> findAll() {
       SqlSession sqlSession= sqlSessionFactory.openSession();
       List<User> userList=sqlSession.selectList("nuc.edu.mybatis.dao.IUserDao.findAll");
       sqlSession.close();
        return userList;
    }
}
