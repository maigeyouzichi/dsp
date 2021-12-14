package com.lz.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lz.service.ResumeServiceFeignClient;
import com.lz.service.SentinelHandlersClass;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
     *
     * @param userId
     * @return
     */
    @SneakyThrows
    @GetMapping("/check-state/{userId}")
    @SentinelResource(value = "/check-state",
            blockHandlerClass = SentinelHandlersClass.class,
            blockHandler = "handleException",
            fallback = "handleError",
            fallbackClass = SentinelHandlersClass.class)
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //TimeUnit.SECONDS.sleep(1);
        int i = 1 / 0;
        return feignClient.findDefaultResumeState(userId);
    }

    /**
     * @SentinelResource
     *  value：定义资源名
        blockHandlerClass：指定Sentinel规则异常兜底逻辑所在class类
        blockHandler：指定Sentinel规则异常兜底逻辑具体哪个⽅法
        fallbackClass：指定Java运⾏时异常兜底逻辑所在class类
        fallback：指定Java运⾏时异常兜底逻辑具体哪个⽅法
     */

}
