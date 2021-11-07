package com.lz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lihao
 * @date 2021-11-07 20:37
 */
@RestController
@RequestMapping("/auto-deliver")
public class controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //调用远程服务
        String url = "http://localhost:8080/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;

    }
}
