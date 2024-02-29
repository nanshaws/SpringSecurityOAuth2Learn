package org.cyl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cyl.pojo.User;

public interface UserService extends IService<User> {
    void saveUserDetail(User user);
}
