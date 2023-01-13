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
@RequestMapping(("/consumerZk/user"))
public class UserController {
    // 这里注意跟Eureka区分开，Zookeeper是区分大小写的
    private final static String PROVIDER_URL = "http://payment-service";
    private final RestTemplate restTemplate;

    @GetMapping("/{id}")
    public CommonResult<User> findById(@PathVariable("id") Long id) {
        String url = PROVIDER_URL + "/provider/user/" + id;
        log.info("url:{}", url);

        return restTemplate.getForObject(url, CommonResult.class);
    }
}
