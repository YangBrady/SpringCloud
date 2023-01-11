package me.yangjun.study.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.dao.UserMapper;
import me.yangjun.study.springcloud.service.IUserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }
}
