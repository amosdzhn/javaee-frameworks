package com.amosdzhn.framework.shiro.shirojavaweb.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @RequiresRoles(value = {"admin"})
    @GetMapping("/test_role")
    @ResponseBody
    public String testRole(){
        return "test_role";
    }

    @RequiresPermissions(value = {"user:add"})
    @GetMapping("/test_perm")
    @ResponseBody
    public String testPermission(){
        return "test_permission";
    }
}
