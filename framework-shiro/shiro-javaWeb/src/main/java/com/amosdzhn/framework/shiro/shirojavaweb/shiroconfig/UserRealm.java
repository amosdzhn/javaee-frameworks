package com.amosdzhn.framework.shiro.shirojavaweb.shiroconfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 该Realm 必须集成Shiro中的Realm
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return jdbc1(principalCollection);
    }

    private AuthorizationInfo jdbc1(PrincipalCollection principalCollection) {
        // 一般通过PrincipalCollection获取用户信息，查询数据库进而查询用户的role和permission
        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
        Set<String> jdbcRoles = new HashSet<>();
        jdbcRoles.add("admin");

        Set<String> jdbcPermissions = new HashSet<>();
        jdbcPermissions.add("user:add");

        sai.setRoles(jdbcRoles);
        sai.setStringPermissions(jdbcPermissions);

        return sai;
    }

    // 用于认证,当调用 subject.login(token) 会进入此处
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return nonEncrypted(authenticationToken);  // 密码未加密
//        return encrypted(authenticationToken);  // 密码加密
    }

    // 当数据库密码未加密
    private AuthenticationInfo nonEncrypted(AuthenticationToken authenticationToken) {
        String identity = (String) authenticationToken.getPrincipal();   // 获取身份(相当于username)
        String credentials = String.valueOf((char[]) authenticationToken.getCredentials());  // 获取密码(凭据)，就是在调用subject.login(token),token中的凭据
        log.info("用户 identity={}",identity);
        log.info("用户 credentials={}",credentials);
        // 在实际应用中，此处通用业务逻辑应该是查询数据库 user = getUserByIdentity(identity)
        // 如果查询的user对象不为Null,则该方法return AuthenticationInfo类型的一个实例
        // 如果返回null,则subject.login(token) 会抛出 没有该用户名的一个Exception
        String jdbcPassword = "123456";
        if(  "admin".equals(identity) ){  // 此处不查询数据库,默认只有一个admin用户
            return new SimpleAuthenticationInfo(identity,jdbcPassword,getName());  // 此处SimpleAuthenticationInfo对象中,第一个参数是该用户在Shiro中的标识，第二个是查询数据库得到的密码
        }
        return null;
    }

    // 数据库密码加密
    private AuthenticationInfo encrypted(AuthenticationToken authenticationToken) {
        String identity = (String) authenticationToken.getCredentials();
        // 查询数据库,存在已经加密的密码
        String jdbcEncryptedPassword = "";
        if( "admin".equals(identity) ){
            return new SimpleAuthenticationInfo(identity,jdbcEncryptedPassword,getName());
        }
        return null;
    }
}
