package com.lz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lihao
 * @date 2021-12-10 17:35
 */
@Data
@Configuration
//@RefreshScope 默认刷新,无需手动指定
@ConfigurationProperties(prefix = "hello")
public class HelloConfig {

    private String name;
    private Integer rank;
    private String test;
}
