package com.lz.anno;

import com.lz.bizEnum.UserEventEnum;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用户事件注解
 * @author lihao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserEventRecord {

    String value() default "";

    UserEventEnum event();

}