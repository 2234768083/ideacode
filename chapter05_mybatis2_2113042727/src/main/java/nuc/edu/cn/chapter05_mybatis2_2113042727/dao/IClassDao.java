package nuc.edu.cn.chapter05_mybatis2_2113042727.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IClassDao {
    public Integer getClass(Integer id) ; //嵌套结果
    public Integer getClass2(Integer id) ; //嵌套查询
}