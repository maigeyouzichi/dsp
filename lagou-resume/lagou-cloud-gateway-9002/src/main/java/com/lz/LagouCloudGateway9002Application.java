package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LagouCloudGateway9002Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouCloudGateway9002Application.class, args);
    }

}
