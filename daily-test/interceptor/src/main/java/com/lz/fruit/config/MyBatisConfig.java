package com.lz.fruit.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.addInterceptor(new TimestampInterceptor());
    }
}
