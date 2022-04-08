package com.amosdzhn.satoken.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户角色关系实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRole {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色id
     */
    private Integer roleId;
}
