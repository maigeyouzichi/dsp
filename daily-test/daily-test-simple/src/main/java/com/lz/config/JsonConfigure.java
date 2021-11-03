package com.lz.config;

import cn.hutool.core.date.DatePattern;
import cn.hutool.json.JSONConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lihao
 * @date 2021-11-03 17:55
 */
@Configuration
public class JsonConfigure {

    @Bean
    public JSONConfig jsonConfig() {
        JSONConfig jsonConfig = new JSONConfig()
                .setDateFormat(DatePattern.NORM_DATETIME_PATTERN)
                .setIgnoreNullValue(false);
        return jsonConfig;
    }
}
