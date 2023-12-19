package nuc.edu.cn.chapter05_mybatis1_2113042727.service;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Emp;

import java.util.List;

public interface IEmpService {
    public List<Emp> findByEmpno(Integer empno);
    public List<Emp>findByDeptno(Integer deptno);
}