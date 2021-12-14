package com.lz.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * ⽤户注册接⼝
     *
     * @return
     */
    @GetMapping("/register")
    @SentinelResource("/user/register")
    public String register() {
        System.out.println("Register success!");
        return "Register success!";
    }

    /**
     * 验证注册身份证接⼝（需要调⽤公安户籍资源）
     *
     * @return
     */
    @SneakyThrows
    @GetMapping("/validateID")
    @SentinelResource("/user/validateID")
    public String findResumeOpenState() {
        System.out.println("validateID");
        //TimeUnit.SECONDS.sleep(10);
        return "ValidateID success!";
    }
}