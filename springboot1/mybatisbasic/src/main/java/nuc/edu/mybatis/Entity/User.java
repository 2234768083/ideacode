package nuc.edu.mybatis.Entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hongjun
 * @create 2020-08-24 15:28
 *  id                   bigint not null,
 *     dept_id              bigint,
 *     username             varchar(20),
 *     password             varchar(50),
 *     realname             varchar(10),
 *     sex                  varchar(10),
 *     telephone            varchar(30),
 *     email                varchar(200),
 *     avatar               varchar(300),
 *     job_title            varchar(30),
 *     status               tinyint,
 *     sort                 int,
 *     del_flag             int comment '0 未删除 1 已删除',
 *     create_time          datetime,
 *     create_by            varchar(20),
 *     update_time          datetime,
 */
@Data
public class User {
   private Integer id;
   private Integer dept_id;
   private String username;
   private String password;
   private String realname;
   private String sex;
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
   private List<Role> roleList;
}
