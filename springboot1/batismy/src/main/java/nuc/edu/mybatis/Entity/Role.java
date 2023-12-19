package nuc.edu.mybatis.Entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hongjun
 * @create 2020-08-27 8:56
 *    id                   bigint not null,
 *    name                 varchar(100),
 *    parent_id            bigint,
 *    type                 tinyint comment '0 分类1 角色',
 *    remarks              varchar(200),
 *    create_by            varchar(50),
 *    create_time          datetime,
 *    update_time          datetime,
 */
@Data
public class Role {
    private Integer id;
    private Integer parent_id;
    private String name;
    private Integer type;
    private String remarks;
    private Date update_time;
    private Date create_time;
    private String createBy;
}
