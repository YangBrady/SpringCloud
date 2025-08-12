package me.yangjun.study.springcloud.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springcloud.common.entitys.CommonResult;
import me.yangjun.study.springcloud.common.entitys.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discover")
    public void discover() {
        List<String> serviceList = discoveryClient.getServices();

        // 获取所有微服务
        for (String service : serviceList) {
            log.info("service: {}", service);
        }

        // 获取所有 PAYMENT-SERVICE 服务实例
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instanceList) {
            log.info("PAYMENT-SERVICE instance: {}", serviceInstance.getInstanceId());
        }
    }
}
