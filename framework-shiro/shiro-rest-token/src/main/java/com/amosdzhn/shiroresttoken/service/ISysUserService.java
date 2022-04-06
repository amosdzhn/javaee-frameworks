package com.amosdzhn.shiroresttoken.service;

import com.amosdzhn.shiroresttoken.entity.SysUser;
import com.amosdzhn.shiroresttoken.model.UserModel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author amosdzhn
 * @since 2022-04-06
 */
public interface ISysUserService extends IService<SysUser> {

    UserModel getUserModelByUsername(String username);

}
