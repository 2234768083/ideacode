package nuc.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import nuc.edu.cn.dao.IUserDao;
import nuc.edu.cn.service.IUserService;
//@Service("userService")
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
	private IUserDao userDao;
    @Value("lisi")
    private String name;
	@Override
	public void saveCustom(String arg) {
		// TODO Auto-generated method stub
		 System.out.println("ҵ��㱻����");
		 System.out.println("����name��"+name);
		 userDao.saveCustom(arg);
	}
	
	
}
