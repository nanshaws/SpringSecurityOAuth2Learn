package org.cyl.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();
//        Object credentials = authentication.getCredentials();
//        Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();

        HashMap result=new HashMap();
        result.put("code",0);
        result.put("message","登录成功");
        result.put("data",principal);
        String json= JSON.toJSONString(result);
        //将数据存入redis之类的

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        //可以跳转到登录成功页面

    }
}
