package com.lz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot内置的事件监听,详细文章:
 * https://segmentfault.com/a/1190000011433514
 * 同时支持有序监听,本项目未实现demo.
 * 默认监听为异步.
 * 如果需要统一事务,可以参考:@TransactionEventListener,文章: https://juejin.cn/book/7049273428938850307/section/7049662725185781792
 */
@SpringBootApplication
public class SpringbootEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEventApplication.class, args);
    }

}
