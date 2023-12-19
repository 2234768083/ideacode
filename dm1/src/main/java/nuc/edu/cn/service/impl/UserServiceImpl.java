package nuc.edu.cn.service.impl;

import nuc.edu.cn.dao.IUserDao;
import nuc.edu.cn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

//    public void setUserDao(IUserDao userDao) {
//        this.userDao = userDao;
//    }

    public void saveUser(String uname) {
      System.out.println("业务层被调用，接收参数："+uname);
      userDao.saveUser(uname);
    }
}
