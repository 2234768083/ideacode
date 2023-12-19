package nuc.edu.cn.springioc2113042727.client;

import nuc.edu.cn.service.IProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IProductService productService = (IProductService) ctx.getBean("productService");
        productService.browse("张三", "联想电脑");
    }

}
