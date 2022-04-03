package com.lz.realize;

/**
 * 如果实现类实现泛型接口,类上不加泛型, 那么需要执行接口的具体类型
 * @author lihao on 2022/3/27
 */
public class Dog implements Generator<Integer>{
    private Integer value;

    @Override
    public Integer getKey() {
        return value;
    }
}
