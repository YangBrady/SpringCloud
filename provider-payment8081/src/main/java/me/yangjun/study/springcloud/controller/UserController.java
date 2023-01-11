package me.yangjun.study.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(("/user"))
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public CommonResult<User> findById(@PathVariable("id") Long id) {
        return new CommonResult<>(200, "查询成功", userService.getById(id));
    }
}
