package me.yangjun.study.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.service.fallback.UserServiceFallback;

@Component
@FeignClient(value = "PAYMENT-SERVICE", fallback = UserServiceFallback.class)
public interface IUserService {
    @GetMapping("/provider/user/findById/{id}")
    CommonResult<User> findById(@PathVariable("id") Long id);

    @GetMapping("/provider/user/findByIdTimeOutHystrix/{id}")
    CommonResult<User> findByIdTimeOutServerHystrix(@PathVariable("id") Long id);

    @GetMapping("/provider/user/findByIdTimeOut/{id}")
    CommonResult<User> findByIdTimeOutClientHystrix(@PathVariable("id") Long id);
}
