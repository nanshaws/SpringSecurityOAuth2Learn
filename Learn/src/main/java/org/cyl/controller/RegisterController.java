package org.cyl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.cyl.pojo.User;
import org.cyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (username != null) {
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("username",username);
            queryWrapper.eq("password",password);
            User user = userService.getOne(queryWrapper);
            if (user != null)
                return "redirect:/error.html";
        }
        PasswordEncoder encoder=new BCryptPasswordEncoder(4);
        String result=encoder.encode(password);
        User user = new User(username, result);
        userService.save(user);
        return "redirect:/login.html";
    }
}
