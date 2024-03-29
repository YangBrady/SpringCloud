package me.yangjun.study.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@MapperScan("me.yangjun.study.springcloud.dao")
public class Application8002 {
    public static void main(String[] args) {
        SpringApplication.run(Application8002.class, args);
    }
}
