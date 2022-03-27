package com.lz.derive;

/**
 * @author lihao on 2022/3/27
 */
public class ChildSecond extends Parent{

    /**
     * 没有指定泛型类型, 默认是object
     */
    @Override
    public Object getValue() {
        return super.getValue();
    }
}
