package com.lz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

    @Test
    public void test003() {
        int[] arr = {1,2,3,0};
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(newArr));
        int a = 1;
        switch (a) {
            case 1 :
                System.out.println();
                break;
        }
        for (int i : arr) {

        }
    }
}
