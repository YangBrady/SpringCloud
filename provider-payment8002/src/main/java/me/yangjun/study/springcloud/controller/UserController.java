package me.yangjun.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.service.IUserService;

@Slf4j
@RestController
@RequestMapping(("/provider/user"))
public class UserController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private IUserService userService;

    /**
     * 正常服务
     *
     * @param id id
     * @return {@link CommonResult}<{@link User}>
     */
    @GetMapping("/findById/{id}")
    public CommonResult<User> findById(@PathVariable("id") Long id) {
        log.info("接收请求, id={}", id);

        User user = userService.getById(id);
        return CommonResult.<User>builder().code(HttpStatus.HTTP_OK).message(appName + ":" + serverPort).data(user)
            .build();
    }

    /**
     * 超时服务，5s
     *
     * @param id id
     * @return {@link CommonResult}<{@link User}>
     */
    @GetMapping("/findByIdTimeOut/{id}")
    public CommonResult<User> findByIdTimeOut(@PathVariable("id") Long id) {
        log.info("接收请求, id={}", id);

        User user = userService.findByIdTimeOut(id);
        return CommonResult.<User>builder().code(HttpStatus.HTTP_OK).message(appName + ":" + serverPort).data(user)
            .build();
    }

    /**
     * 超时服务5s，2s后提供熔断服务
     *
     * @param id id
     * @return {@link CommonResult}<{@link User}>
     */
    @GetMapping("/findByIdTimeOutHystrix/{id}")
    public CommonResult<User> findByIdTimeOutHystrix(@PathVariable("id") Long id) {
        log.info("接收请求, id={}", id);

        User user = userService.findByIdTimeOutHystrix(id);
        return CommonResult.<User>builder().code(HttpStatus.HTTP_OK).message(appName + ":" + serverPort).data(user)
            .build();
    }
}
