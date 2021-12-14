package com.lz.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelHandlersClass {
// 整体要求和当时Hystrix⼀样，这⾥还需要在形参最后添加BlockException参数，⽤于接收异常

    // 注意：⽅法是静态的
    public static Integer handleException(Long userId, BlockException blockException) {
        return -100;
    }

    public static Integer handleError(Long userId) {
        return -500;
    }
}