package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 测试点:
 * 1,文件名指定环境
 * 2,动态刷新
 * 3,同一个文件指定环境
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LagouCloudNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagouCloudNacosConfigApplication.class, args);
    }

}
