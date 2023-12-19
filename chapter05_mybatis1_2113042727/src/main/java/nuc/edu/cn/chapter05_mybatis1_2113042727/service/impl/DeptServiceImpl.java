package nuc.edu.cn.chapter05_mybatis1_2113042727.service.impl;

import nuc.edu.cn.chapter05_mybatis1_2113042727.dao.IDeptDao;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Dept;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDao deptDao;
    @Override
    public Dept findByDeptno(Integer deptno) {
// TODO Auto-generated method stub
        return deptDao.findByDeptno(deptno);
    }
}