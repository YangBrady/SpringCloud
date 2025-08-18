package me.yangjun.study.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.service.IUserService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@DefaultProperties(defaultFallback = "defaultHystrixHandler")
public class UserService implements IUserService {
    @Override
    public User getById(Long id) {
        log.debug("id={}", id);
        return User.builder().id(id).name("yangjun").age(18).build();
    }

    @Override
    public User findByIdTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(6);
            log.debug("sleep over");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    @HystrixCommand(
        fallbackMethod = "findByIdTimeOutHystrixHandler",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.enable", value = "true")
        }
    )
    public User findByIdTimeOutHystrix(Long id) {
        log.debug("id={}", id);
        try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {throw new RuntimeException(e);}
        log.debug("sleep over"); // 降级以后不会执行
        return null;
    }

    @Override
    @HystrixCommand
    public User findByIdTimeOutHystrix2(Long id) {
        log.debug("id={}", id);
        try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {throw new RuntimeException(e);}
        log.debug("sleep over"); // 降级以后不会执行
        return null;
    }

    /**
     * Hystrix兜底方法
     *
     * @param id id
     * @return {@link User}
     */
    private User findByIdTimeOutHystrixHandler(Long id) {
        log.error("服务端降级, id={}, ", id);
        return new User();
    }

    /**
     * Hystrix默认兜底方法
     */
    private User defaultHystrixHandler() {
        log.error("服务端降级 默认方法");
        return User.builder().remark("😭").build();
    }
}
