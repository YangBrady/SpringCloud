package me.yangjun.study.springcloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(("/consumer/OpenFeign"))
public class UserController {

    private final IUserService userService;
    @GetMapping("/user/{id}")
    public CommonResult<User> findById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }
}
