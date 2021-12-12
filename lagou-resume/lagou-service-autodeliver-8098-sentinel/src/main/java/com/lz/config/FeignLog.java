package com.lz.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Feign Log
 * 默认级别需要大于内层日志级别,否则不会显示
 * @author lihao
 * @date 2021-11-28 22:52
 */
@Configuration
public class FeignLog {

    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
