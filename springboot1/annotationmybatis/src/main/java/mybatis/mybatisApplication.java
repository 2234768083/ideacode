package mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hongjun
 * @create 2020-10-28 9:19
 */
@SpringBootApplication
@MapperScan("mybstis.dao")
public class mybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(mybatisApplication.class,args);
    }
}
