package com.lz.aspect;

import com.alibaba.fastjson.JSON;
import com.lz.anno.UserEventRecord;
import com.lz.bizEnum.UserEventEnum;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author lihao
 */
@Aspect
@Component
@Slf4j
public class UserEventAspect {
    @Pointcut(value = "@annotation(com.lz.anno.UserEventRecord)")
    public void brokerAspect(){ }
    
    @Around(value = "brokerAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        UserEventRecord annotation = method.getAnnotation(UserEventRecord.class);
        UserEventEnum event = annotation.event();
        Object[] args = point.getArgs();
        log.info("获取事件 : {}", event.getName());
        String params = JSON.toJSONString(args);
        log.info("获取参数: {}", params);
        return point.proceed();
    }
}