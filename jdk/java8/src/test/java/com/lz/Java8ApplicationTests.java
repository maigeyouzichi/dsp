package com.lz;

import com.lz.entity.Apple;
import com.lz.entity.Orange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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
        Apple apple_1 = new Apple(1, 10, 10);
        Apple apple_2 = new Apple(2, 20, 10);
        Apple apple_3 = new Apple(3, 30, 10);
        Apple apple_4 = new Apple(4, 40, 10);
        Apple apple_5 = new Apple(5, 50, 10);
        List<Apple> appleList = Arrays.asList(apple_1, apple_5, apple_2, apple_3, apple_4);
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
//        appleList.sort(Comparator.comparing(obj -> obj.getWeight()));
        appleList.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println(appleList);
        appleList.sort(((o1, o2) -> o2.getWeight().compareTo(o1.getWeight())));//倒序排序
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry)); //倒序排序
        System.out.println(appleList);
//        Collections.reverse(appleList);
//        System.out.println(appleList);
        Stream<Apple> stream = appleList.stream();
    }

    /**
     * int数组转List<Integer>
     */
    @Test
    void testArrayToList() {
        int[] arr = {1, 2, 4};
        IntStream stream = Arrays.stream(arr);
        Stream<Integer> boxed = stream.boxed();
        List<Integer> list = boxed.collect(toList());
        System.out.println(list);
    }

    @Test
    void testMaxInt() {
        int[] arr = {1, 3, 5};
        OptionalInt max = Arrays.stream(arr).max();
        int rns = max.orElse(1);
    }

    /**
     * 判断某个数是否为整数
     * 如果带有小数,就返回false
     */
    @Test
    void testDouble() {
        System.out.println(9.0 % 1 == 0);
        System.out.println(9.1 % 1 == 0);
    }

    @Test
    void testPriority() {
        PriorityQueue<Apple> apples = new PriorityQueue<>((o1, o2) -> o2.getWeight().compareTo(o1.getWeight()));
    }

    @Test
    void testGrouping() {
        Apple apple_1 = new Apple(1, 10, 10);
        Apple apple_2 = new Apple(2, 20, 10);
        Apple apple_3 = new Apple(3, 30, 10);
        Apple apple_4 = new Apple(4, 40, 10);
        Apple apple_5 = new Apple(5, 50, 10);
        Map<Integer, List<Orange>> map = Stream.of(apple_1, apple_2, apple_3).collect(groupingBy(Apple::getId, mapping(obj -> new Orange(obj.getId(), obj.getWeight()),toList())));
        System.out.println(map);
    }

    @Test
    void testRunTimeProcess() {
        int num = Runtime.getRuntime().availableProcessors();
        System.out.println(num);
    }

    /**
     * 方法引用替换Lambda表达式
     * Lambda表达式替换接口的实现类,并声明其方法的实现逻辑
     */
    @Test
    void testSupply() {
        Supplier<Apple> supplier = Apple::new;
        Apple apple = supplier.get();
    }

    @Test
    void testOptional() {
        Optional<Apple> appleOptional = Optional.of(new Apple());
        Optional<Integer> weight = appleOptional.map(Apple::getWeight);
        System.out.println(weight.orElse(11));
        System.out.println(weight.orElseGet(() -> 12));
    }
}
