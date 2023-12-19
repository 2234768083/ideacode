package nuc.edu.thymeleaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hongjun
 * @create 2020-10-22 15:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;
    int age;
    User friend;// 对象类型属性
    public User(String name,int age){
        this.name=name;
        this.age=age;
    }
}