package com.lz.service;


import com.lz.anno.AspectLog;
import com.lz.anno.UserEventRecord;
import com.lz.bizEnum.UserEventEnum;
import com.lz.controller.req.LoginReq;
import com.lz.controller.req.LoginReq2;
import com.lz.entity.Order;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
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


    @SneakyThrows
    @AspectLog(value = "yyy", bizNo = "#orderId")
    @Retryable(include = RetryException.class, backoff = @Backoff(delay = 1000, multiplier = 1.5))
    public String test02(Integer orderId) {
        log.info("test02执行 ....");
        boolean flag = true;
        if (flag) {
            throw new RetryException("重试异常 ..");
        }
        return "success";
    }

    @SneakyThrows
    @AspectLog(value = "yyy", bizNo = "#order.purchaseName")
    @Retryable(include = RetryException.class, backoff = @Backoff(delay = 1000, multiplier = 1.5))
    public String test03(Order order) {
        log.info("test02执行 ....");
        boolean flag = true;
        if (flag) {
            throw new RetryException("重试异常 ..");
        }
        return "success";
    }

    @UserEventRecord(event = UserEventEnum.LOGIN)
    public void login(LoginReq req, LoginReq2 req2) {

    }

    @UserEventRecord(event = UserEventEnum.LOGIN)
    public void login2() {

    }

    @UserEventRecord(event = UserEventEnum.LOGIN)
    public void login3(String name) {

    }

    @UserEventRecord(event = UserEventEnum.LOGIN)
    public void login4(String name, Integer age) {

    }

    @UserEventRecord(event = UserEventEnum.LOGIN)
    public void login5(String name, LoginReq req) {

    }
}
