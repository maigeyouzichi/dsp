package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // 开启hystrix dashboard
public class LagouCloudHystrixDashboard9000Application {

    public static void main(String[] args) {
        SpringApplication.run(LagouCloudHystrixDashboard9000Application.class, args);
    }

}
