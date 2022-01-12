package com.lz.service;


import com.lz.anno.AspectLog;
import com.lz.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 测试服务类
 * @author lihao
 */
@Service
@Slf4j
public class TestService {

    @AspectLog(value = "xxx", bizNo = "#order.purchaseName")
    public void doSomeThing(Order order) {
        log.info("do something ...");
    }


    @AspectLog(value = "yyy", bizNo = "#orderId")
    public String test02(Integer orderId) {
        log.info("test02");
        int i = 1/0;
        return "success";
    }
}
