package com.lz.realize;

import com.lz.quickStart.ProductGetter;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author lihao on 2022/3/27
 */
public class RealizeTest {

    @Test
    public void test1() {
        Apple apple = new Apple();
        String key = apple.getKey();
        System.out.println(key);

        System.out.println("--------");

        Pair<String,Integer> pair = new Pair<>("Java", 1000);
        String key1 = pair.getKey();
        Integer value = pair.getValue();
    }

    //泛型方法支持和所在类类型不一致
    @Test
    public void test2() {
        ProductGetter<Integer> product = new ProductGetter<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Kotlin");
        //泛型方法的调用,类型是通过调用方法的时候进行指定的
        String product1 = product.getProduct(list);
        System.out.println("result: " + product1);

        System.out.println("--------");

        ProductGetter.printType("Java",100, true);
        ProductGetter.print("Java",100, true);
    }
}
