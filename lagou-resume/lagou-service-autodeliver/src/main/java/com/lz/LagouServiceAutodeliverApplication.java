package com.lz;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
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
