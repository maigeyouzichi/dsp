package com.lz.realize;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * 泛型接口实现类,是一个泛型类,那么要保证实现接口的泛型类泛型标识包含泛型接口的泛型标识
 * @author lihao on 2022/3/27
 */
@Setter
@AllArgsConstructor
public class Pair<T,E> implements Generator<T> {

    private T key;

    private E value;

    @Override
    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }
}
