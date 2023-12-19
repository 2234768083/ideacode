package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("名称")
    @Alias("名称")
    private String name;

    @ApiModelProperty("价格")
    @Alias("价格")
    private BigDecimal price;

    @ApiModelProperty("图片")
    @Alias("图片")
    private String img;

    @ApiModelProperty("描述")
    @Alias("描述")
    private String descpription;
    private String unit;

    @ApiModelProperty("库存")
    @Alias("库存")
    private Integer nums;

    @ApiModelProperty("状态")
    @Alias("状态")
    private Boolean status;


}
