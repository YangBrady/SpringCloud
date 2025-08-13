package me.yangjun.study.springcloud.service;

import me.yangjun.study.springcloud.common.entitys.User;

public interface IUserService {

    /**
     * 通过userId查询
     *
     * @param id id
     * @return {@link User}
     */
    User getById(Long id);

    /**
     * 超时测试
     *
     * @param id id
     * @return {@link User}
     */
    User findByIdTimeOut();

    /**
     * 超时服务5s，2s后提供熔断服务
     *
     * @param id id
     * @return {@link User}
     */
    User findByIdTimeOutHystrix(Long id);
    User findByIdTimeOutHystrix2(Long id);
}
