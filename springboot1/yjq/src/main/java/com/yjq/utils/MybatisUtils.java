package com.yjq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    public static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis对象第一步，获取sqlSessionFactory对象
            //String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //已经有了 SqlSessionFactory 对象了,我们就可以获得SqlSession的实例了。
    // SqlSession 对象完全包含以数据库为背景的所有执行 SQL 操作的 方法。

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
