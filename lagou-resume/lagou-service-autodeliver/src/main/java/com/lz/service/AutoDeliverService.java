package com.lz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao
 * @date 2021-11-24 20:43
 */
@Service
public class AutoDeliverService {


    @SneakyThrows
    @HystrixCommand(
            //熔断细节属性配置 每一个属性都是一个HystrixProperty
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            },
            //回退方法
            fallbackMethod = "myFallBack"
    )
    public Integer deliver() {
        TimeUnit.SECONDS.sleep(10);
        return 10;
    }

    public Integer myFallBack(){
        return -2;
    }
}
