package nuc.edu.cn.chapter05_mybatis1_2113042727.service.impl;

import nuc.edu.cn.chapter05_mybatis1_2113042727.dao.IRoleDao;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Role;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public Role findById(Integer id) {
// TODO Auto-generated method stub
        return roleDao.findById(id);
    }
}
