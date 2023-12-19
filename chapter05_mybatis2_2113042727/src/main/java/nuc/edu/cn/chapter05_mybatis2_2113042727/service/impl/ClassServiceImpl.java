package nuc.edu.cn.chapter05_mybatis2_2113042727.service.impl;

import nuc.edu.cn.chapter05_mybatis2_2113042727.dao.IClassDao;
import nuc.edu.cn.chapter05_mybatis2_2113042727.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;
    @Override
    public Integer getClass(Integer id) {
// TODO Auto-generated method stub
        return classDao.getClass(id);
    }
    @Override
    public Integer getClass2(Integer id) {
// TODO Auto-generated method stub
        return classDao.getClass(id);
    }
}