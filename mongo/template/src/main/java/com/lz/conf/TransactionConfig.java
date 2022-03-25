package com.lz.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * 配置事务管理器
 * 单节点 mongodb 不支持事务，需要搭建 MongoDB 复制集。
 * @author mydlq
 */
@SuppressWarnings("all")
//@Configuration
public class TransactionConfig {

    @Bean
    MongoTransactionManager transactionManager(SimpleMongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

}
