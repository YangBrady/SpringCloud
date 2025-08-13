package me.yangjun.study.springcloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

// @Component 放入IOC容器就会自动注册拦截器，就不用@Bean处理了
public class AuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("x-request-id", "ltia");
    }
}
