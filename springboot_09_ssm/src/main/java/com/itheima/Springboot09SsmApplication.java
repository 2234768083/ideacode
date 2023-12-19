package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Springboot09SsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot09SsmApplication.class, args);
		System.out.println("SpringBoot启动成功");
		System.out.println("请访问页面，页面地址是：http://localhost/pages/books.html");
	}

}
