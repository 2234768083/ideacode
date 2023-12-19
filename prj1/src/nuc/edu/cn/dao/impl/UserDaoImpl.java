package nuc.edu.cn.dao.impl;

import nuc.edu.cn.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	@Override
	public void saveCustom(String arg) {
		// TODO Auto-generated method stub
       System.out.println("持久层被调用"+arg);
	}

}
