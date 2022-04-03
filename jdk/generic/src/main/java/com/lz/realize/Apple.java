package com.lz.realize;

/**
 * 实现泛型接口的类,不是泛型类,需要明确实现泛型接口的数据类型
 * @author lihao on 2022/3/27
 */
public class Apple implements Generator<String> {

    @Override
    public String getKey() {
        return "Hello World";
    }
}
