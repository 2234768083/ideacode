package nuc.edu.cn.chapter05_mybatis1_2113042727.service.impl;

import nuc.edu.cn.chapter05_mybatis1_2113042727.dao.IEmpDao;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Emp;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private IEmpDao empDao;
    @Override
    public List<Emp> findByEmpno(Integer empno) {
// TODO Auto-generated method stub
        return empDao.findByEmpno(empno);
    }
    @Override
    public List<Emp>findByDeptno(Integer deptno) {
// TODO Auto-generated method stub
        return empDao.findByDeptno(deptno);
    }
}