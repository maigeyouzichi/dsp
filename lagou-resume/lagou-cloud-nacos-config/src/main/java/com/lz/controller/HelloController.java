package com.lz.controller;

import com.lz.config.HelloConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 * @date 2021-12-10 18:26
 */
@RestController
public class HelloController {

    private final HelloConfig helloConfig;

    public HelloController(HelloConfig helloConfig) {
        this.helloConfig = helloConfig;
    }

    @GetMapping("/hello/world")
    public String helloWorld() {
        System.out.println(helloConfig.getRank());
        System.out.println(helloConfig.getName());
        return "success";
    }
}
