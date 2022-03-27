package com.lz.common;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author lihao on 2022/3/27
 */
public class SimpleService {

    public int method1(int i, String s , Collection<?> c, Serializable serializable) {
        throw new RuntimeException();
    }

    public void method2(int i, String s , Collection<?> c, Serializable serializable) {
        throw new RuntimeException();
    }
}
