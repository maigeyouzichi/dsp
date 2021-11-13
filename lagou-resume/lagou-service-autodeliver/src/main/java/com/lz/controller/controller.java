package com.lz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@SuppressWarnings("all")
public class controller {

    @Autowired
    private RestTemplate restTemplate;

    /*@GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //调用远程服务
        String url = "http://localhost:8080/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }*/

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * Eureka改造
     * @param userId
     * @return
     */
    /*@GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //1,从Eureka Server中获取服务的实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("LAGOU-SERVICE-RESUME");
        //2,如果返回多了,选择一个使用(负载均衡)
        ServiceInstance serviceInstance = instances.get(0);
        //3,从元数据中获取host port
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://"+host+":"+port+"/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }*/


    /**
     * 改造 -> Ribbon 负载均衡
     * @param userId
     * @return
     */
    @GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //不需要自己获取服务实例然后选择一个去访问,只需要指定服务名
        String url = "http://LAGOU-SERVICE-RESUME/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }



}
