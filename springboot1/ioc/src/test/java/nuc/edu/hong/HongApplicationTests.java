package nuc.edu.hong;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import nuc.edu.hong.service.IUserClientService;
import org.apache.naming.factory.BeanFactory;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.ClasspathResourceSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

@SpringBootTest
class HongApplicationTests {

    @Test
    void contextLoads() {
    }
/*
 //依赖注入方式实现
    @Autowired
    private IUserClientService userClientService;
    @Test
    public void testAnnocation(){

        userClientService.saveCustom();
    }*/
    @Test
    public void testBean(){
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //XmlBeanFactory beanFactory= new XmlBeanFactory(new ClassPathResource("bean.xml"));
        // 根据beanID获取对象
        // 调用前必须在springContext.xml中配置注解方式解析
       //IUserClientService userClientService = (IUserClientService) ac.getBean("customService");
        IUserClientService userClientService = ac.getBean(IUserClientService.class);
        userClientService.saveCustom();
        //IUserClientService userService1=(IUserClientService) ac.getBean("customService");
        //System.out.println(userService1==userClientService);
    }

}

