package me.yangjun.study.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.service.IUserService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(("/consumer/OpenFeign/user"))
public class UserController {

    private final IUserService userService;

    @GetMapping("/findById/{id}")
    public CommonResult<User> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/findByIdTimeOutServerHystrix/{id}")
    public CommonResult<User> findByIdTimeOutServerHystrix(@PathVariable("id") Long id) {
        return userService.findByIdTimeOutServerHystrix(id);
    }

    @GetMapping("/findByIdTimeOutClientHystrix/{id}")
    public CommonResult<User> findByIdTimeOutClientHystrix(@PathVariable("id") Long id) {
        return userService.findByIdTimeOutClientHystrix(id);
    }
}
