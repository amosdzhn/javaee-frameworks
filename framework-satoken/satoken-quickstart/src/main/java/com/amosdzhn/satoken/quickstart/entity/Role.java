package com.amosdzhn.satoken.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 系统角色实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;
}
