package me.yangjun.study.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.yangjun.study.springcloud.common.entitys.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
