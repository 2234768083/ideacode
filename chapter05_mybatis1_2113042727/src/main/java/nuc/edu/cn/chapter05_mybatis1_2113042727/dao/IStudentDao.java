package nuc.edu.cn.chapter05_mybatis1_2113042727.dao;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStudentDao {
    public Student findById(Integer id);
}
