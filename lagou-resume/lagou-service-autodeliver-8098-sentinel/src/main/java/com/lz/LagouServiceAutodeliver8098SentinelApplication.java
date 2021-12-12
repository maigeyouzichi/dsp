package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LagouServiceAutodeliver8098SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagouServiceAutodeliver8098SentinelApplication.class, args);
    }

}
