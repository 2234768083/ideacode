package nuc.edu.cn.chapter05_mybatis1_2113042727.service.impl;

import nuc.edu.cn.chapter05_mybatis1_2113042727.dao.IStudentDao;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Student;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Override
    public Student findById(Integer id) {
// TODO Auto-generated method stub
        return studentDao.findById(id);
    }
}
