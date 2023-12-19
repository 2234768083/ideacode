package nuc.edu.hong;

import nuc.edu.hong.service.IUserClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class HongApplicationTests {

    @Test
    void contextLoads() {
    }
 //依赖注入方式实现
 @Autowired
    private IUserClientService userClientService;
    @Test
    public void testAnnocation(){

        userClientService.saveCustom();
    }
/*    @Test
    public void testBean(){
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("springContext.xml");
        // 根据beanID获取对象
        // 调用前必须在springContext.xml中配置注解方式解析
        IUserClientService userClientService = (IUserClientService) ac.getBean("customService");
        userClientService.saveCustom();
        //IUserClientService userService1=(IUserClientService) ac.getBean("customService");
        //System.out.println(userService1==userClientService);
    }*/

}

