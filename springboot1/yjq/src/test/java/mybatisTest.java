import com.yjq.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.yjq.dao.UserDao;
import com.yjq.utils.MybatisUtils;

import java.util.List;

/**
 * @author hongjun
 * @create 2021-10-12 10:18
 */
public class mybatisTest {
    @Test
    public void testMybatis(){
        UserDao userDao;
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一:getMapper
        userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
        }
        //关闭sqlSession
        sqlSession.close();
    }
}
