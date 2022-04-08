package com.amosdzhn.satoken.quickstart.service.impl;

import com.amosdzhn.satoken.quickstart.entity.*;
import com.amosdzhn.satoken.quickstart.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 假装数据库
 */
@Service
public class UserServiceImpl implements IUserService {

    private static List<User> users;
    private static List<Role> roles;
    private static List<Permission> permissions;

    private static List<UserRole> userRoles;
    private static List<RolePermission> rolePermissions;

    // init DB
    static {
        // permission table
        permissions = new ArrayList<>();
        permissions.add(new Permission(1,"book:read","可以读 book"));
        permissions.add(new Permission(2,"book:write","可以写 book"));
        permissions.add(new Permission(3,"book:update","可以修改 book"));
        permissions.add(new Permission(4,"book:delete","可以删除 book"));
        permissions.add(new Permission(5,"user:info:read","读取user信息"));
        permissions.add(new Permission(6,"user:info:update","修改user信息"));
        permissions.add(new Permission(7,"user:password:update","修改用户密码"));
        permissions.add(new Permission(8,"book:password:read","查看用户密码"));

        roles = new ArrayList<>();
        roles.add(new Role(1,"admin","超级管理员"));
        roles.add(new Role(2,"user","一般用户"));
        roles.add(new Role(3,"manager","管理员"));

        rolePermissions = new ArrayList<>();
        rolePermissions.add(new RolePermission(1,1,1));
        rolePermissions.add(new RolePermission(2,1,2));
        rolePermissions.add(new RolePermission(3,1,3));
        rolePermissions.add(new RolePermission(4,1,4));
        rolePermissions.add(new RolePermission(5,1,5));
        rolePermissions.add(new RolePermission(6,1,6));
        rolePermissions.add(new RolePermission(7,1,7));
        rolePermissions.add(new RolePermission(8,1,8));
        rolePermissions.add(new RolePermission(9,2,1));
        rolePermissions.add(new RolePermission(10,2,5));
        rolePermissions.add(new RolePermission(11,2,8));

        users = new ArrayList<>();
        users.add(new User(1,"zs","123456","salt","zs@qq.com"));

        userRoles = new ArrayList<>();
        userRoles.add(new UserRole(1,1,2));
    }


    @Override
    public User queryUser(String username) {
        for (User user : users) {
            if( user.getUsername().equals(username) ){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<Role> queryUserRoles(String username) {
        User user = queryUser(username);
        if( user == null ){
            return null;
        }
        Integer userId = user.getId();

        Set<Integer> roleIds = userRoles.stream().filter(userRole -> {
            return userRole.getUserId().equals(userId);
        }).map(UserRole::getRoleId).collect(Collectors.toSet());

        List<Role> res = roles.stream().filter(role -> {
            boolean flag = false;
            for (Integer roleId : roleIds) {
                if (roleId.equals(role.getId())) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }).collect(Collectors.toList());

        return res;
    }

    @Override
    public List<Permission> queryUserPermissions(String username) {
        List<Role> roles = queryUserRoles(username);
        Set<Integer> roleIds = roles.stream().map(Role::getId).collect(Collectors.toSet());

        List<Integer> permissionIds = rolePermissions.stream().filter(rolePermission -> {
                    boolean flag = false;
                    for (Integer roleId : roleIds) {
                        if (roleId.equals(rolePermission.getRoleId())) {
                            flag = true;
                            break;
                        }
                    }
                    return flag;
                }).map(RolePermission::getPermissionId)
                .collect(Collectors.toList());

        List<Permission> res = UserServiceImpl.permissions.stream().filter(permission -> {
            boolean flag = false;
            for (Integer permissionId : permissionIds) {
                if (permissionId.equals(permission.getId())) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }).collect(Collectors.toList());

        return res;
    }
}
