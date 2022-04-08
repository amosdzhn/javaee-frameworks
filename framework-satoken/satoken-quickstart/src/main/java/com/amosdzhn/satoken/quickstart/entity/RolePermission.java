package com.amosdzhn.satoken.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 角色权限关系实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RolePermission {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色主键
     */
    private Integer roleId;

    /**
     * 权限主键
     */
    private Integer permissionId;
}
