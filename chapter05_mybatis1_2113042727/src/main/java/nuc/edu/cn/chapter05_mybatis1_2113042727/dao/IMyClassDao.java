package nuc.edu.cn.chapter05_mybatis1_2113042727.dao;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.MyClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMyClassDao {
    public MyClass getMyClass(Integer id) ; //嵌套结果
    public MyClass getMyClass2(Integer id) ; //嵌套查询
}