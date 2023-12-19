package nuc.edu.mybatis.Entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hongjun
 * @create 2020-08-27 8:53
 *    id                   bigint not null,
 *    parent_id            bigint comment '上级部门id,一级部门为0',
 *    name                 varchar(50),
 *    type                 tinyint comment '0：公司；1部门；2科室/小组',
 *    sort                 int default 0,
 *    status               tinyint comment '状态0正常，1禁用',
 *    update_time          datetime,
 *    create_by            bigint,
 *    create_time          datetime,
 */
@Data
public class Dept {
    private Integer id;
    private Integer parent_id;
    private String name;
    private Integer type;
    private Integer sort;
    private Integer status;
    private Date updateTime;
    private Date createTime;
    private String createBy;

}
