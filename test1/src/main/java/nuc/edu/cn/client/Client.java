package nuc.edu.cn.client;

import nuc.edu.cn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService= (IUserService) ac.getBean("userService");
        userService.saveUser("张三");
    }
}
