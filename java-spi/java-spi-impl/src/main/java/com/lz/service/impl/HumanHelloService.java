package com.lz.service.impl;

import com.lz.service.HelloService;

/**
 * @author lihao
 * @date 2021-10-31 21:30
 */
public class HumanHelloService implements HelloService {

    @Override
    public String sayHello() {
        return "hello 你好";
    }
}
