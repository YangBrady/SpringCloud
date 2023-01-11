package me.yangjun.study.springcloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(("/consumer/user"))
public class UserController {
    private final static String PROVIDER_URL = "http://127.0.0.1:8081/provider/user/";
    private final RestTemplate restTemplate;

    @GetMapping("/{id}")
    public CommonResult<User> findById(@PathVariable("id") Long id) {
        String url = PROVIDER_URL + id;
        log.debug("url:{}", url);

        return restTemplate.getForObject(url, CommonResult.class);
    }
}
