package org.cyl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.cyl.pojo.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
