package nuc.edu.cn.dao.impl;

import org.springframework.stereotype.Repository;

import nuc.edu.cn.dao.IUserDao;
@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	public void saveCustom(String arg) {
		// TODO Auto-generated method stub
       System.out.println("�־ò㱻����"+arg);
	}

}
