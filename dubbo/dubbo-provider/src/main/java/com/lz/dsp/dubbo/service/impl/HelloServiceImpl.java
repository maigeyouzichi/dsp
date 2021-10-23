package com.lz.dsp.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lz.dsp.dubbo.api.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author lihao
 * @date 2021-10-23 13:52
 */
@Component
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}