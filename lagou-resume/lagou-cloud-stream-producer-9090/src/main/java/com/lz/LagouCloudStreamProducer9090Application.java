package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LagouCloudStreamProducer9090Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouCloudStreamProducer9090Application.class, args);
    }

}
