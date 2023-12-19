package nuc.edu.mybatis;

import nuc.edu.mybatis.Entity.User;
import nuc.edu.mybatis.Entity.UserC;
import nuc.edu.mybatis.Entity.queryVO;
import nuc.edu.mybatis.dao.IUserDao;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author hongjun
 * @create 2020-05-02 17:20
 */
public class mybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @BeforeEach
    public void init() throws IOException {
        //1 读取配置文件
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3 使用工厂生产SqlSession对象
         sqlSession= factory.openSession();
        //4 使用SqlSession创建Dao接口的代理对象
         userDao = sqlSession.getMapper(IUserDao.class);
    }
    @AfterEach
    public void destroy() throws IOException {
        in.close();
        sqlSession.close();
    }

    /*
    * 测试查询操作
    * */
    @Test
    public void testFindAll() throws Exception {

        //5 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }

    }
    @Test
    public void testonecache() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3 使用工厂生产SqlSession对象
        SqlSession sqlSession1 = factory.openSession();
        //4 使用SqlSession创建Dao接口的代理对象
        User user1=userDao.findUserById(1);
        User user2=userDao.findUserById(1);
        System.out.println(user1==user2);


    }
    @Test
    public void testtwocache() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3 使用工厂生产SqlSession对象
        SqlSession sqlSession1 = factory.openSession();
        //4 使用SqlSession创建Dao接口的代理对象
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user=userDao1.findUserById(1);
        System.out.println(user);
        sqlSession1.close();
        SqlSession sqlSession2=factory.openSession();
        IUserDao userDao2=sqlSession2.getMapper(IUserDao.class);
        User user1= userDao2.findUserById(1);
        System.out.println(user1);
        sqlSession2.close();
        System.out.println(user==user1);


    }


    /*
    * 测试保存用户信息
    *
    * */
    @Test
    public void insertUser() throws IOException {
        User user=new User();
        user.setUsername("hongjun");
        user.setPassword("hongjun");
        user.setRealname("洪军");
        user.setSex("男");
        user.setDept_id(1);
        System.out.println("执行前："+user);

        //5 使用代理对象执行方法
        userDao.insertUser(user);
        System.out.println("执行后："+user);
        //6 释放资源
        sqlSession.commit();
        /*sqlSession.close();
        in.close();*/

    }
    /*
    *测试更新
    * */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(10);
        user.setUsername("hh");
        userDao.updateUser(user);
        sqlSession.commit();

    }
    /*
    * 测试删除
    * */
    @Test
    public void testDelete(){
        userDao.deleteUserById(4);
        sqlSession.commit();

    }
    /*
    * 测试按照id查询用户信息
    * */
    @Test
    public void testFindUserById(){
        User user=userDao.findUserById(1);
        System.out.println(user);
    }
    /*
     * 测试按照姓名查询用户信息
     * */
    @Test
    public void testFindUserByName(){
        List<User> userList=userDao.findUserByName("hong");
        for (User user:userList
             ) {
            System.out.println(user);
        }
    }
    /*
    * 查询用户数
    * */
    @Test
    public void testToltal(){
        int result=userDao.totalCount();
        System.out.println("总用户数为："+result);
    }
    /*
    * 包装类查询
    * */
    @Test
    public void findUserList(){
        queryVO queryVO=new queryVO();
        User user=new User();
        user.setUsername("%h%");
        queryVO.setUser(user);
        List<User> userList=userDao.findUserList(queryVO);
        for (User u:userList
             ) {
            System.out.println(u);
        }

    }
    @Test
    public void findAllUserC(){
        List<UserC> userCList=userDao.findAllUserC();
        for (UserC c:userCList
             ) {
            System.out.println(c);
        }


    }

       /*
     * 根据条件查询
     * */
    @Test
    public void testFindbyCondition() throws Exception {
        User user=new User();
        user.setUsername("hongjun");
        user.setSex("男");
        List<User> userList= userDao.findUserByCondition(user);
        for (User u:userList
        ) {
            System.out.println(u);
        }
    }
    /*
     * 集合查询
     * */
    @Test
    public void testfindUserinIds() throws Exception {
        queryVO queryVO=new queryVO();
        queryVO.setIds(Arrays.asList(1,2,3));
        List<User> userList= userDao.findUserinIds(queryVO);
        for (User u:userList
        ) {
            System.out.println(u);
        }
    }

@Test
    public void TestJDBC(){
    //数据库连接
    Connection connection = null;
    //预编译的Statement，使用预编译的Statement提高数据库性能
    PreparedStatement preparedStatement = null;
    //结果 集
    ResultSet resultSet = null;

    try {
        //加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //通过驱动管理类获取数据库链接
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?&serverTimezone=Asia/Shanghai", "root", "hongjun");
        //定义sql语句 ?表示占位符
        String sql = "select * from user where username = ? ";
        //获取预处理statement
        preparedStatement = connection.prepareStatement(sql);
        //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
        preparedStatement.setString(1, "王五");
        //向数据库发出sql执行查询，查询出结果集
        resultSet =  preparedStatement.executeQuery();
        //遍历查询结果集
        while(resultSet.next()){
            System.out.println(resultSet.getString("id")+resultSet.getString("address")+resultSet.getString("username"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        //释放资源
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
    @Test
    public void TestJDBCasdf(){
        //数据库连接
        Connection connection = null;
        //预编译的Statement，使用预编译的Statement提高数据库性能
        PreparedStatement preparedStatement = null;
        //结果 集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis?&serverTimezone=Asia/Shanghai", "root", "hongjun");
            //定义sql语句 ?表示占位符
            String sql = "insert into user values(?,?,?,?,?,?)";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "王五");
            //向数据库发出sql执行查询，查询出结果集
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+resultSet.getString("address")+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
    @Test
    public void TestJDBCmany(){
        //数据库连接
        Connection connection = null;
        //预编译的Statement，使用预编译的Statement提高数据库性能
        PreparedStatement preparedStatement = null;
        //结果 集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?&serverTimezone=Asia/Shanghai", "root", "hongjun");
            //定义sql语句 ?表示占位符
            String sql = "select * from user  ";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
           // preparedStatement.setString(1, "王五");
            //向数据库发出sql执行查询，查询出结果集
            resultSet =  preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+resultSet.getString("address")+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
