package nuc.edu.cn.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nuc.edu.cn.service.IUserService;
import nuc.edu.cn.service.impl.UserServiceImpl;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      // IUserService userService=new IUserServiceImpl();
	   ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
	//   IUserService userService=(IUserService)ac.getBean("userService");
	   IUserService userService=(IUserService)ac.getBean("userService");
       userService.saveCustom("ZHANGSAN");
	}

}
