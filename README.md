持续更新中

# SpringCloud
跟着尚硅谷周阳老师SpringCloud学习、代码、笔记记录

[尚硅谷2020最新版SpringCloud(H版&Alibaba)](https://www.bilibili.com/video/BV18E411x7eT)

### 进度
- [x] RestTemplate调用版
- [x] Eureka 单机版
  - [x] EurekaServer 单机版
  - [x] EurekaClient服务提供者 单机版
- [x] Eureka 集群版
    - [x] EurekaServer 集群版
    - [x] EurekaClient服务提供者 集群版
    - [x] EurekaClient消费者 请求负载均衡
- [x] zookeeper 注册中心 
- [x] Ribbon 负载均衡
- [x] OpenFeign 服务调用
- [ ] Hystrix 服务降级
    - [x] 服务侧降级
    - [x] 消费侧降级

### 端口说明
* 7001/7002 Eureka Server
* 8001/8002 Eureka Client 微服务提供者
* 8002 Hystrix
* 8003 Zookeeper 微服务提供者
* 80 Eureka Client 消费者/Zookeeper 消费者

### Host配置
```text
127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com
```