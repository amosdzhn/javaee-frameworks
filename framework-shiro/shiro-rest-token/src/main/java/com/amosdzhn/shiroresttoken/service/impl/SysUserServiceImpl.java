package com.amosdzhn.shiroresttoken.service.impl;

import com.amosdzhn.shiroresttoken.entity.*;
import com.amosdzhn.shiroresttoken.mapper.*;
import com.amosdzhn.shiroresttoken.model.UserModel;
import com.amosdzhn.shiroresttoken.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author amosdzhn
 * @since 2022-04-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    ISysUserRoleService userRoleService;
    @Resource
    ISysRoleService roleService;
    @Resource
    ISysRolePermissionService rolePermissionService;
    @Resource
    ISysPermissionService permissionService;
    @Resource
    SysUserRoleMapper userRoleMapper;
    @Resource
    SysRoleMapper roleMapper;
    @Resource
    SysRolePermissionMapper rolePermissionMapper;
    @Resource
    SysPermissionMapper permissionMapper;

    @Override
    public UserModel getUserModelByUsername(String username) {

        // 查用户
        SysUser sysUser = getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, username));
        if( sysUser==null ){
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setSysUser(sysUser);

        // 根据用户id,查用户角色集
        List<SysUserRole> sysUserRoles = userRoleMapper.selectList(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::getUserid,sysUser.getId()));
        if( sysUserRoles.size() == 0 ){
            Set<SysRole> roleSet = new HashSet<>();
            Set<SysPermission> permissionSet = new HashSet<>();
            userModel.setRoles(roleSet);
            userModel.setPermissions(permissionSet);
            return userModel;
        }else {
            List<Integer> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleid).collect(Collectors.toList());
            // 根据角色id集，查角色集
            List<SysRole> sysRoles = roleMapper.selectBatchIds(roleIds);
            Set<SysRole> roleSet = new HashSet<>(sysRoles);
            userModel.setRoles(roleSet);

            // 根据角色id集，查角色权限集
            List<SysRolePermission> rolePermissions = rolePermissionMapper.selectBatchIds(roleIds);
            Set<Integer> permissionIds = rolePermissions.stream().map(SysRolePermission::getPermissionid).collect(Collectors.toSet());

            if( permissionIds.size() == 0 ){
                Set<SysPermission> permissionSet = new HashSet<>();
                userModel.setPermissions(permissionSet);
            }else {
                // 根据权限id集，查权限实体集
                List<SysPermission> sysPermissions = permissionMapper.selectBatchIds(permissionIds);
                Set<SysPermission> permissionSet = new HashSet<>(sysPermissions);
                userModel.setPermissions(permissionSet);
            }
        }

        return userModel;
    }
}
