package com.lz.dsp.dubbo.controller;

import com.lz.dsp.dubbo.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 * @date 2021-10-23 13:59
 */
@RestController
@Slf4j
public class DubboConsumerController {

    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        String hello = helloService.sayHello("world");
        System.out.println(hello);
        //测试日志打印存储
        /*log.debug("log debug ...");
        log.info("log info ...");
        log.warn("log warning ...");
        log.error("log error ...");*/
        return hello;
    }

}
