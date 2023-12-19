package nuc.edu.mybatis.Entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hongjun
 * @create 2020-08-27 8:55
 *    id                   bigint not null,
 *    parent_id            bigint,
 *    name                 varchar(50),
 *    url                  varchar(200),
 *    permission           varchar(200) comment '多个用逗号分隔',
 *    type                 tinyint comment '类型：0目录，1菜单2按钮3导航菜单',
 *    icon                 varchar(50),
 *    status               tinyint comment '0正常1禁用',
 *    sort                 int,
 *    create_by            bigint,
 *    create_time          datetime,
 *    update_time          datetime,
 *    primary key (id)
 */
@Data
public class Menu {
    private Integer id;
    private Integer parent_id;
    private String name;
    private String url;
    private String permission;
    private Integer type;
    private Integer sort;
    private Integer status;
    private Date updateTime;
    private Date createTime;
    private String createBy;
}
