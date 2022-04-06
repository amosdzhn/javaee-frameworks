package com.amosdzhn.shiroresttoken.model;

import com.amosdzhn.shiroresttoken.entity.SysPermission;
import com.amosdzhn.shiroresttoken.entity.SysRole;
import com.amosdzhn.shiroresttoken.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel {
    private SysUser sysUser;
    private Set<SysRole> roles;
    private Set<SysPermission> permissions;

    @Override
    public String toString() {
        return "UserModel{" +
                "sysUser=" + sysUser +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}
