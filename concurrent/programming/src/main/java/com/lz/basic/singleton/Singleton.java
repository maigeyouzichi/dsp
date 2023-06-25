package com.lz.basic.singleton;

/**
 * 手写double check 单例
 * @author lihao on 2023/3/11
 */
public class Singleton {

    /**
     * 添加volatile,禁止指令重排,保证线程安全.
     */
    private static volatile Singleton instance;

    /**
     * 构造器私有
     */
    private Singleton(){}

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
