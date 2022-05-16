package com.lz;

import org.junit.Test;

@SuppressWarnings("all")
public class Test001 {

    @Test
    public void test001() {
        int i = 1;
        i = i ++;
        int j = i ++;
        int k = i + ++i*i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void test002() {
        String str = 123+"";
        char[] chars = str.toCharArray();
    }
}
