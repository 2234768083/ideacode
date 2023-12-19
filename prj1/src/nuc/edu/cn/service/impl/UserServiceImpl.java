package nuc.edu.cn.service.impl;

import nuc.edu.cn.dao.IUserDao;
import nuc.edu.cn.dao.impl.UserDaoImpl;
import nuc.edu.cn.service.IUserService;

public class UserServiceImpl implements IUserService {
//    private IUserDao userDao;
//   	public IUserDao getUserDao() {
//		return userDao;
//	}
//	public void setUserDao(IUserDao userDao) {
//		this.userDao = userDao;
//	}
	private String driver;
	private int port;

//	public IUserServiceImpl(String driver, int port) {
//		super();
//		this.driver = driver;
//		this.port = port;
//	}
	
	

	@Override
	public void saveCustom(String arg) {
		// TODO Auto-generated method stub
		System.out.println("业务层被调用"+arg);
		//userDao=new UserDaoImpl();
	//	userDao.saveCustom(arg);
		System.out.println("driver:"+driver+">>"
				+"port:"+port);
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
