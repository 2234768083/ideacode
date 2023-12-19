package nuc.edu.cn.dao.impl;

import org.springframework.stereotype.Repository;

import nuc.edu.cn.dao.IUserDao;
@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	public void saveCustom(String arg) {
		// TODO Auto-generated method stub
       System.out.println("持久层被调用"+arg);
	}

}
