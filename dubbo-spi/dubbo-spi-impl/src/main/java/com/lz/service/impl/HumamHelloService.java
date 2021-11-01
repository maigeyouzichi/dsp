package com.lz.service.impl;

import com.lz.service.HelloService;
import org.apache.dubbo.common.URL;

/**
 * @author lihao
 * @date 2021-11-01 22:49
 */
public class HumamHelloService implements HelloService {
    @Override
    public String sayHello() {
        return "你好!";
    }

    @Override
    public String sayHello(URL url) {
        return "你好! url";
    }
}
