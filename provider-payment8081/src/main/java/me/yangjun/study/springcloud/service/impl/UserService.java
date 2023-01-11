package me.yangjun.study.springcloud.service.impl;

import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.dao.UserMapper;
import me.yangjun.study.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }
}
