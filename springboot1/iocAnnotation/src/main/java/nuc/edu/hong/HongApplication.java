package nuc.edu.hong;

import nuc.edu.hong.service.IUserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HongApplication {

    public static void main(String[] args) {
        SpringApplication.run(HongApplication.class, args)  ;

    }

}
