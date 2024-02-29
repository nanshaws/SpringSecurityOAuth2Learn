package org.cyl.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class IndexController {

   @GetMapping("/")
    public HashMap index(){
       SecurityContext context= SecurityContextHolder.getContext();
       Authentication authentication = context.getAuthentication();
       Object credentials = authentication.getCredentials();//密码
       Object principal = authentication.getPrincipal();//身份
       Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();//权限

       String name=authentication.getName();

       HashMap result=new HashMap();
       result.put("username",name);
       result.put("authorities",authorities);
       return result;
    }
}
