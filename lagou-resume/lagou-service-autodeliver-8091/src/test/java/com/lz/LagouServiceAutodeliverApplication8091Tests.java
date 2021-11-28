package com.lz;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest(classes = {LagouServiceAutodeliverApplication8091.class})
@RunWith(SpringRunner.class)
class LagouServiceAutodeliverApplication8091Tests {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    void testEurekaInstanceMateMap() {

        //1,从Eureka Server中获取服务的实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("LAGOU-SERVICE-RESUME");
        //2,如果返回多了,选择一个使用(负载均衡)
        ServiceInstance serviceInstance = instances.get(0);
        System.out.println(serviceInstance.getHost());
        System.out.println(serviceInstance.getPort());
        Set<Map.Entry<String, String>> entries = serviceInstance.getMetadata().entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
