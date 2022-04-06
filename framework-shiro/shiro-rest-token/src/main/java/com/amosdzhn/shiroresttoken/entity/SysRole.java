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
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "")
public class SysRole {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty("描述")
    private String description;


}
