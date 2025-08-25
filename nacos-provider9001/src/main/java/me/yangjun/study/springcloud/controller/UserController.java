package me.yangjun.study.springcloud.controller;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(("/provider/user"))
public class UserController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/findById/{id}")
    public CommonResult<User> findById(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("yangjun");
        user.setAge(18);
        return new CommonResult<>(200, "查询成功, serverPort=" + serverPort, user);
    }

    @GetMapping("/timeout")
    public CommonResult<User> timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        User user = new User();
        user.setId(1L);
        user.setName("yangjun");
        user.setAge(18);
        return new CommonResult<>(200, "查询成功, serverPort=" + serverPort, user);
    }
}
