package nuc.edu.aop;

import nuc.edu.aop.Config.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
    @Bean(name="myAspect")
    public MyAspect initMyAspect(){
        return new MyAspect();
}
}
