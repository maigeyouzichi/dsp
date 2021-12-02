package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LagouCloudStreamConsumer9092Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouCloudStreamConsumer9092Application.class, args);
    }

}
