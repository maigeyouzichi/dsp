package com.lz.test;

import com.lz.service.HelloService;

import java.util.ServiceLoader;

/**
 * @author lihao
 * @date 2021-10-31 21:39
 */
public class JavaSpiMain {

    public static void main(String[] args) {
        ServiceLoader<HelloService> helloServices = ServiceLoader.load(HelloService.class);
        for (HelloService helloService : helloServices) {
            System.out.println(helloService.getClass().getName()+":"+helloService.sayHello());
        }
    }
}
