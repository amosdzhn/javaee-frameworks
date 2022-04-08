package com.amosdzhn.satoken.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 系统权限实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Permission {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 描述
     */
    private String description;
}
