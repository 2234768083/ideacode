package nuc.edu.springmvc.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author hongjun
 * @create 2020-10-06 9:54
 */
@Data
public class User {
    @NotNull(message = "用户id不能为空！")
    private Integer id;

    private String name;
    @Email(message = "登录名必须是电子邮件！")
    private String email;

    @NotNull //不能为空
    @DecimalMin(value="0.1")  // 最小值0.1元
    @DecimalMax(value = "10000.00") //最大值10000 元
    private Double doubleValue = null;
    @Future(message = "必须输入一个大于今天的日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd") //日期格式化转换
    @NotNull  //不能为空
    private Date date;
    @Length(min=6,message = "密码长度不低于6位")
    private String password;
    @Min(value = 1, message=" 最小值为1") //最小值为1
    @Max(value = 88, message ="最大值为88") //最大值为88
    @NotNull//不能为空
    private Integer integer;
    @Range(min = 1 , max=88, message="范围为1至88日") //限定范围
    private Long range;
    @Size(min=20, max = 30, message="字符串长度要求20至30之间")
    private String size;



}
