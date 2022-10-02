package com.lz;

import com.lz.entity.Apple;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
class Java8ApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 一个简单的例子, 感受lambda和方法引用的优雅
     */
    @Test
    void testSort() {
        Apple apple_1 = new Apple(1,10);
        Apple apple_2 = new Apple(2,20);
        Apple apple_3 = new Apple(3,30);
        Apple apple_4 = new Apple(4,40);
        Apple apple_5 = new Apple(5,50);
        List<Apple> appleList = Arrays.asList(apple_1,apple_5,apple_2,apple_3,apple_4);
        System.out.println(appleList);
        /*Collections.sort(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });*/
        /*Collections.sort(appleList, Comparator.comparing(Apple::getWeight));*/
        /**优化之后的版本,sort函数需要一个比较器,比较器支持函数引用*/
        appleList.sort(Comparator.comparing(Apple::getWeight));//正序排序
        appleList.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println(appleList);
        appleList.sort(((o1, o2) -> o2.getWeight().compareTo(o1.getWeight())));//倒序排序
        System.out.println(appleList);
//        Collections.reverse(appleList);
//        System.out.println(appleList);
    }

}
