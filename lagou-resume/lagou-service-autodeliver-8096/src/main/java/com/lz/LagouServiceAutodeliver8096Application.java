package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启feign客户端功能
public class LagouServiceAutodeliver8096Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouServiceAutodeliver8096Application.class, args);
    }

}
