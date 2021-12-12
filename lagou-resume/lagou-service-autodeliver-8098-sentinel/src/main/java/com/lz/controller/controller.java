package com.lz.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lz.service.ResumeServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 * @date 2021-11-07 20:37
 */
@RestController
@RequestMapping("/auto-deliver")
public class controller {

    @Autowired
    private ResumeServiceFeignClient feignClient;

    /**
     * 改造 -> Ribbon 负载均衡
     * @param userId
     * @return
     */
    @GetMapping("/check-state/{userId}")
    @SentinelResource("/check-state")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        return feignClient.findDefaultResumeState(userId);
    }

}
