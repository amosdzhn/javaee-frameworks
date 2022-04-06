package com.amosdzhn.shiroresttoken.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author amosdzhn
 * @since 2022-04-06
 */
@Getter
@Setter
@ToString
@TableName("sys_permission")
@ApiModel(value = "SysPermission对象", description = "")
public class SysPermission {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("描述")
    private String description;


}
