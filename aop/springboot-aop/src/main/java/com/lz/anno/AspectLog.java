package com.lz.anno;

import java.lang.annotation.*;

/**
 * 切面注解
 * @author lihao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectLog {

    String value() default "";

    String bizNo();
}