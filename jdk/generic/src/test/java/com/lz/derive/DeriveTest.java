package com.lz.derive;

import org.junit.Test;

/**
 * @author lihao on 2022/3/27
 */
public class DeriveTest {

    @Test
    public void test1() {
        ChildFirst<String> stringChildFirst = new ChildFirst<>();
        stringChildFirst.setValue("Java");
        String value = stringChildFirst.getValue();
        System.out.println(value);
    }

    @Test
    public void test02() {
        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue(100);
        Object value = childSecond.getValue();
        System.out.println(value);
    }
}
