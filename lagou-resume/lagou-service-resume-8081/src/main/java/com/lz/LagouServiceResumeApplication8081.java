package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lihao
 * {@code @EnableEurekaClient 开启Eureka客户端}
 * {@code @EnableDiscoveryClient 开始通用注册中心客户端: 适用于Nacos/Eureka}
 * 从springCloud Edgware 版本开始,不添加xxxClinet注解也行,建议加上 :)
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class LagouServiceResumeApplication8081 {

    public static void main(String[] args) {
        SpringApplication.run(LagouServiceResumeApplication8081.class, args);
    }
}
