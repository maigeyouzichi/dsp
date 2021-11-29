package com.lz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * {@code @FeignClient 表名当前类是一个Feign客户端, value指定该客户端要请求的服务名称(注册中心暴露的服务名称)}
 * @author lihao
 * @date 2021-11-28 21:10
 */
@FeignClient(value = "lagou-service-resume",fallback = ResumeFallBack.class,path = "/resume")
//@RequestMapping("/resume") 这么写会报错,路径需要上移
public interface ResumeServiceFeignClient {

    /**
     * 查询简历状态
     * @param userId id
     * @return stateId
     * Feign要做的事情就是,拼装url发起请求
     */
    @GetMapping("/open-state/{userId}")
    Integer findDefaultResumeState(@PathVariable("userId") Long userId);
}
