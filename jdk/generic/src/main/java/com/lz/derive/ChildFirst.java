package com.lz.derive;

/**
 * 派生
 * 继承 -- 泛型类型同父类保持一致
 * @author lihao on 2022/3/27
 */
public class ChildFirst<T> extends Parent<T> {

    @Override
    public T getValue() {
        return super.getValue();
    }
}
