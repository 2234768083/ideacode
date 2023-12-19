package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import cn.hutool.core.annotation.Alias;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-01-18
 */
@Getter
@Setter
@ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("订单编号")
    @Alias("订单编号")
    private String orderno;

    @ApiModelProperty("总金额")
    @Alias("总金额")
    private BigDecimal total;

    @ApiModelProperty("用户id")
    @Alias("用户id")
    private Integer userid;

    @ApiModelProperty("状态")
    @Alias("状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    @Alias("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;

    @ApiModelProperty("付款时间")
    @Alias("付款时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime payTime;

    @ApiModelProperty("付款编号")
    @Alias("付款编号")
    private String payno;


    @TableField(exist = false)
    private List<OrderItem> orderItems;


}
