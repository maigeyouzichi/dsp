package com.lz.erase;

import java.util.List;

/**
 * 类型擦除 适用于泛型类和泛型方法
 * 1, T -> Object
 * 2, T extend E -> E
 *
 * 桥接方法:
 * 泛型接口, 实现类指定具体类型,方法会保持一个object类型的桥接方法,同时保持一个具体类型的方法
 * @author lihao
 * @date 2022-04-04 15:03
 */
public class Erase<T extends Number> {

    public T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <T extends List> T show(T t) {
        return t;
    }
}
