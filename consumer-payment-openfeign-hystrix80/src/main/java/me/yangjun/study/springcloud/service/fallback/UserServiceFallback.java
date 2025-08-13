package me.yangjun.study.springcloud.service.fallback;

import org.springframework.stereotype.Component;

import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import me.yangjun.study.springcloud.service.IUserService;

@Slf4j
@Component
public class UserServiceFallback implements IUserService {
    @Override
    public CommonResult<User> findByIdTimeOut() {
        return CommonResult.<User>builder().code(HttpStatus.HTTP_INTERNAL_ERROR).message("客户端降级兜底").build();
    }

    @Override
    public CommonResult<User> findById(Long id) {
        log.error("异常，客户端熔断, id={}", id);

        return CommonResult.<User>builder().code(HttpStatus.HTTP_INTERNAL_ERROR).message("客户端熔断兜底").build();
    }

    @Override
    public CommonResult<User> findByIdTimeOutServerHystrix(Long id) {
        // 服务端熔断时间 >= 客户端熔断时间的时候才会出发
        log.error("服务端熔断检测时间过长，客户端开始熔断, id={}", id);
        return CommonResult.<User>builder().code(HttpStatus.HTTP_INTERNAL_ERROR).message("客户端熔断兜底").build();
    }

    @Override
    public CommonResult<User> findByIdTimeOutClientHystrix(Long id) {
        log.error("客户端开始熔断, id={}", id);
        return CommonResult.<User>builder().code(HttpStatus.HTTP_INTERNAL_ERROR).message("客户端熔断兜底").build();
    }
}
