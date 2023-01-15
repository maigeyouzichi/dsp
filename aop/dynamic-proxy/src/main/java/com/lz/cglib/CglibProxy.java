package com.lz.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 代理逻辑编写对象
 * CGLIB是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，
 *      但因为采用的是继承，所以不能对final修饰的方法进行代理
 * @author lihao
 */
public class CglibProxy implements MethodInterceptor {

    public Object newInstall(Object object) {
        return Enhancer.create(object.getClass(), this);
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我被CglibProxy代理了");
        return methodProxy.invokeSuper(o, objects);
    }

}
