package me.yangjun.study.springcloud.service;

import me.yangjun.study.springcloud.common.entitys.User;

public interface IUserService {
    User getById(Long id);
}
