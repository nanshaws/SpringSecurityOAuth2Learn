package org.cyl.controller;

import org.cyl.pojo.User;
import org.cyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('USER_ADD')")
    public List<User> getList(){
        return userService.list();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN') and authentication.name=='admin'")
    public void add(@RequestBody User user){
        userService.saveUserDetail(user);
    }

}
