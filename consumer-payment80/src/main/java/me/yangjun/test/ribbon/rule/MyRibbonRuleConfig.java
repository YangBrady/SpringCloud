package me.yangjun.test.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import me.yangjun.study.springcloud.config.MyRibbonRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbonRuleConfig {
    @Bean
    public IRule myRule() {
        // return new RandomRule();
        return new MyRibbonRule();
    }
}
