package com.lz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 * @date 2021-12-05 20:21
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public String findResumeOpenState() {
        return "demo/test!";
    }
}
