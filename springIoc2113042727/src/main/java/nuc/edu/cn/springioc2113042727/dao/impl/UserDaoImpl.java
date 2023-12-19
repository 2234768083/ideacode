package nuc.edu.cn.springioc2113042727.dao.impl;

import nuc.edu.cn.springioc2113042727.dao.IUserDao;

public class UserDaoImpl implements IUserDao {
    @Override
    public void saveCustom(String arg) {
// TODO Auto-generated method stub
        System.out.println("持久层被调用 ");
        System.out.println("持久层接收参数 ："+arg);
    }
}
