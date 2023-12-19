package mybatis;

import nuc.edu.mybatis.Entity.User;
import nuc.edu.mybatis.dao.IUserDao;
import nuc.edu.mybatis.dao.IUserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author hongjun
 * @create 2020-05-02 17:20
 */
public class mybatisTest {
    @Test
    public void testFindAll() throws Exception {
        //1 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3 使用工厂创建userDao
        IUserDao userDao=new IUserDaoImpl(factory);
        //4 使用对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        //5 释放资源
        //sqlSession.close();
        in.close();
    }
}
