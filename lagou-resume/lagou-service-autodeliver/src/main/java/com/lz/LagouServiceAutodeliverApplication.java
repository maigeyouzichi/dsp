package com.lz;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * {@code @SpringCloudApplication 通用application,包括了@SpringBootApplication,@EnableDiscoveryClient,@EnableCircuitBreaker}
 * {@code @EnableHystrix 开启hystrix}
 * {@code @EnableCircuitBreaker 通用断路器,可替代hystrix}
 */
@SpringCloudApplication
public class LagouServiceAutodeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagouServiceAutodeliverApplication.class, args);
    }


    /**
     * 修改ribbon负载均衡策略 方式二
     * 方式一为修改yaml配置文件
     */
    //@Bean
    public RoundRobinRule createRule(){
        return new RoundRobinRule();
    }
}
