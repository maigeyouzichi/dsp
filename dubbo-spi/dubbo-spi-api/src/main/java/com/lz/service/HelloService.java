package com.lz.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author lihao
 * @date 2021-11-01 22:41
 */
@SPI("dog")
public interface HelloService {
    String sayHello();
    @Adaptive
    String sayHello(URL url);
}
