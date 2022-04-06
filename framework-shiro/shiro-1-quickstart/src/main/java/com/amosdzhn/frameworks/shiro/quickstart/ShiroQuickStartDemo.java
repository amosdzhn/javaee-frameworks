package com.amosdzhn.frameworks.shiro.quickstart;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author amosdzhn
 * descrption: Shiro入门
 */
public class ShiroQuickStartDemo {
    public static void main(String[] args) {
        System.out.println("这是我的第一个Shiro程序");

        // 1.创建SecurityManager的一个工厂类
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2. 获取SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //3. SecurityUtils指向 SecurityManager
        SecurityUtils.setSecurityManager(securityManager);



        Subject currentUser = SecurityUtils.getSubject();
        System.out.println("===测试session:");
        Session session = currentUser.getSession();
        session.setAttribute("userId","uid:001");
        String userId = (String) session.getAttribute("userId");
        System.out.println("userId: " + userId);


        // 认证
        if(  !currentUser.isAuthenticated() ){
            //  创建一个token
            UsernamePasswordToken token = new UsernamePasswordToken("user1", "pwd1");
            token.setRememberMe(true);
            try {
                // 登录
                currentUser.login(token);
            }catch (UnknownAccountException uae){
                System.out.println("错误:未知的用户名");
            }catch (IncorrectCredentialsException ice){
                System.out.println("错误:密码错误");
            }catch (LockedAccountException lae){
                System.out.println("错误:该账户被锁定");
            }
            // 其他的异常，或自定义一些异常
            catch (AuthenticationException ae){
                System.out.println("错误:认证异常");
            }
        }


        System.out.println("===获取用户的信息:");
        String principal = (String) currentUser.getPrincipal();
        System.out.println( "当前用户的身份" + principal);


        System.out.println("===测试用户的角色:");
        // 用户是否拥有某个角色
        boolean admin = currentUser.hasRole("admin");
        System.out.println("当前用户有admin角色? " + admin);
        boolean generally = currentUser.hasRole("generally");
        System.out.println("当前用户有generally角色? " + generally);

        System.out.println("===测试用户的权限:");
        // 用户是否拥有某个权限
        boolean bookRead = currentUser.isPermitted("book:read");
        System.out.println("当前用户有book:read权限? " + bookRead);
        boolean bookDelete = currentUser.isPermitted("book:delete");
        System.out.println("当前用户有book:delete权限？" + bookDelete);

        // 登出
        currentUser.logout();

        System.exit(0);
    }
}
