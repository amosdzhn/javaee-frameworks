package com.amosdzhn.satoken.quickstart.pojo.dto;


import lombok.Data;

/**
 * @author amosdzhan
 * 用户登录对象
 */
@Data
public class UserLoginDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
