package com.lz.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 代理逻辑编写对象,生成代理类是需要传入该对象
 * @author lihao
 */
public class JDKInvocationHandler<T> implements InvocationHandler{

    private final T target;

    public JDKInvocationHandler(T target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("增强操作,打印方法名: "+method.getName());
        return method.invoke(target, args);
    }

}
