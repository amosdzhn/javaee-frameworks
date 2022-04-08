package com.amosdzhn.satoken.quickstart.service;

import com.amosdzhn.satoken.quickstart.entity.Permission;
import com.amosdzhn.satoken.quickstart.entity.Role;
import com.amosdzhn.satoken.quickstart.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 根据用户名 查询用户
     * @param username - 用户名
     * @return
     */
    User queryUser(String username);

    /**
     * 根据用户名 查询用户角色
     * @param username - 用户名
     * @return
     */
    List<Role> queryUserRoles(String username);

    /**
     * 根据用户名 查询用户权限
     * @param username - 用户权限
     * @return
     */
    List<Permission> queryUserPermissions(String username);
}
