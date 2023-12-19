package nuc.edu.mybatis.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hongjun
 * @create 2020-08-24 15:28
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserC {
   private Integer userId;
   private String userName;
   private String userSex;

   private Integer dept_id;
   private String password;
   private String realname;
   private String telephone;
   private String email;
   private String avastar;
   private String jobTitle;
   private Integer status;
   private Integer sort;
   private Integer delFlag;
   private Date createTime;
   private Date updateTime;
   private String createBy;
}
