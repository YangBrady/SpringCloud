package me.yangjun.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class Application8002 {
    public static void main(String[] args) {
        SpringApplication.run(Application8002.class, args);
    }
}
