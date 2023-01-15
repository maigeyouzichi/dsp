package com.lz.jdk.reflect;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author lihao
 */
public class JDKProxy {

    /**
     * 获取代理对象
     */
    public static <T> T getProxy(T t) {
        InvocationHandler handler = new JDKInvocationHandler(t);
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), handler);
    }
}
