package org.cyl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.cyl.config.DBUserDetailsManager;
import org.cyl.mapper.UserMapper;
import org.cyl.pojo.User;
import org.cyl.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private DBUserDetailsManager dbUserDetailsManager;

    @Override
    public void saveUserDetail(User user) {
        UserDetails userDetails= org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        dbUserDetailsManager.createUser(userDetails);
    }
}
