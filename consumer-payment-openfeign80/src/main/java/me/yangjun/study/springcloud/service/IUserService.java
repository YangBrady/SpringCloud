package me.yangjun.study.springcloud.service;

import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("PAYMENT-SERVICE")
public interface IUserService {

    @GetMapping("/provider/user/findById/{id}")
    CommonResult<User> getById(@PathVariable("id") Long id);

    @GetMapping("/provider/user/timeout")
    CommonResult<User> timeout();
}
