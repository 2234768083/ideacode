package nuc.edu.cn.chapter05_mybatis1_2113042727.dao;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IEmpDao {
    public List<Emp> findByEmpno(Integer empno);
    public List<Emp>findByDeptno(Integer deptno);
}
