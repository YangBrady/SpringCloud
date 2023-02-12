package me.yangjun.study.springcloud.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.dao.UserMapper;
import me.yangjun.study.springcloud.service.IUserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserMapper userMapper;

    @Override
    public User getById(Long id) {
        log.debug("id={}", id);
        return userMapper.selectById(id);
    }

    @Override
    public User findByIdTimeOut(Long id) {
        try {
            log.debug("id={}", id);
            TimeUnit.SECONDS.sleep(6);
            log.debug("sleep over");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userMapper.selectById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "findByIdErrorHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    public User findByIdTimeOutHystrix(Long id) {
        try {
            log.debug("id={}", id);
            TimeUnit.SECONDS.sleep(5);
            log.debug("sleep over"); // 熔断以后不会执行
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Hystrix兜底方法
     *
     * @param id id
     * @return {@link User}
     */
    private User findByIdErrorHandler(Long id) {
        log.error("服务端熔断, id={}, ", id);
        return new User();
    }
}
