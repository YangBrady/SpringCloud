package me.yangjun.study.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.dao.UserMapper;
import me.yangjun.study.springcloud.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserMapper userMapper;

    @HystrixCommand(fallbackMethod = "findByIdErrorHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    @Override
    public User getById(Long id) {
        try {
            log.info("id={}", id);
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userMapper.selectById(id);
    }

    @Override
    public User findByIdErrorHandler(Long id) {
        log.error("调用失败");
        return new User();
    }
}
