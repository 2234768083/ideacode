package nuc.edu.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

/**
 * @author hongjun
 * @create 2020-10-23 7:51
 */
@SpringBootApplication
public class helloApplication {
    public static void main(String[] args) {
        SpringApplication.run(helloApplication.class,args);
        System.out.println("hello springboot");

    }
}
