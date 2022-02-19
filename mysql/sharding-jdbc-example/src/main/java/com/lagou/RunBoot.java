package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lihao
 */
@EnableTransactionManagement
@SpringBootApplication
public class RunBoot {
    public static void main(String[] args) {
        SpringApplication.run(RunBoot.class,args);
    }
}
