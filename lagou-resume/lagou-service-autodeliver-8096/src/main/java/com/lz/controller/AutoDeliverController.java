package com.lz.controller;

import com.lz.service.ResumeServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 * @date 2021-11-28 20:56
 */
@RestController
@RequestMapping("/auto-deliver")
public class AutoDeliverController {

    @Autowired
    private ResumeServiceFeignClient feignClient;

    @GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //不需要自己获取服务实例然后选择一个去访问,只需要指定服务名
        /*String url = "http://LAGOU-SERVICE-RESUME/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;*/

        return feignClient.findDefaultResumeState(userId);
    }
}
