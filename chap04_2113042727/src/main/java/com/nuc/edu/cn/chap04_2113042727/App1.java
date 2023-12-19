package com.nuc.edu.cn.chap04_2113042727;

import com.nuc.edu.cn.chap04_2113042727.interceptor.Interceptor1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication(scanBasePackages="com.nuc.edu.cn.chap04_2113042727")
public class App1 implements WebMvcConfigurer {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        SpringApplication.run(App1.class, args);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
// TODO Auto-generated method stub
        InterceptorRegistration ir=registry.addInterceptor(new
                Interceptor1());
        ir.addPathPatterns("/interceptor/*");
    }
}
