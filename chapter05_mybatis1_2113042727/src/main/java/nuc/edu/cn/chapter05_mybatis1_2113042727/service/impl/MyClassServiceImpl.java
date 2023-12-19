package nuc.edu.cn.chapter05_mybatis1_2113042727.service.impl;

import nuc.edu.cn.chapter05_mybatis1_2113042727.dao.IMyClassDao;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.MyClass;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IMyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyClassServiceImpl implements IMyClassService {
    @Autowired
    private IMyClassDao classDao;
    @Override
    public MyClass getMyClass(Integer id) {
// TODO Auto-generated method stub
        return classDao.getMyClass(id);
    }
    @Override
    public MyClass getMyClass2(Integer id) {
// TODO Auto-generated method stub
        return classDao.getMyClass(id);
    }
}