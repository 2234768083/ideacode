package nuc.edu;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hongjun
 * @create 2020-12-09 8:43
 */
@SpringBootApplication
//@MapperScan("nuc.edu.mapper")
public class mybatisplus {
    public static void main(String[] args) {
        SpringApplication.run(mybatisplus.class,args);
    }
}
