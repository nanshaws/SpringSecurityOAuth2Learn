package org.cyl.controller;

import org.cyl.pojo.User;
import org.cyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/list")
    public List<User> getList(){
        return userService.list();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.saveUserDetail(user);
    }

}
