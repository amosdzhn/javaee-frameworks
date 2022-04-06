package com.amosdzhn.shiroresttoken.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@TableName("sys_user_role")
@ApiModel(value = "SysUserRole对象", description = "")
public class SysUserRole {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userid;

    @ApiModelProperty(" 角色id")
    private Integer roleid;


}
