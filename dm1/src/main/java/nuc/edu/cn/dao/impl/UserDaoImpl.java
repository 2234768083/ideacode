package nuc.edu.cn.dao.impl;

import nuc.edu.cn.dao.IUserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {
    public void saveUser(String uname) {
        System.out.println("持久层被调用，接收参数："+uname);
    }
}
