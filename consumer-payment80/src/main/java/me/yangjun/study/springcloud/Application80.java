package me.yangjun.study.springcloud;

import me.yangjun.test.ribbon.rule.MyRibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
// @RibbonClient(name = "PAYMENT-SERVICE", configuration = MyRibbonRuleConfig.class)
@RibbonClients(
    defaultConfiguration = MyRibbonRuleConfig.class,
    value = {
        @RibbonClient(name = "PAYMENT-SERVICE", configuration = MyRibbonRuleConfig.class)
    }
)
public class Application80 {
    public static void main(String[] args) {
        SpringApplication.run(Application80.class, args);
    }
}