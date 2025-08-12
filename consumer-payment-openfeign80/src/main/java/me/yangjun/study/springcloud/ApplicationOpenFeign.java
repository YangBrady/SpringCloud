package me.yangjun.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplicationOpenFeign {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationOpenFeign.class, args);
    }
}