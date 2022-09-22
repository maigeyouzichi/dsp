package com.lz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StreamApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello world");
    }

    /**
     * 数组转集合
     */
    @Test
    void testStream001() {
        int[] intArr = {1,2,3,4,5,6,7,8,9};
        List<Integer> arrList = Arrays.stream(intArr).boxed().limit(3).collect(Collectors.toList());
        System.out.println(arrList);
    }

    @Test
    void testStream002() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        List<Integer> collect = stream.filter(e -> e > 1).collect(Collectors.toList());
        System.out.println(collect.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList()).get(0));
        System.out.println(collect);
    }

    @Test
    void test003() {
        ArrayList<Integer> list = new ArrayList<>(2);
        Integer[] arr = new Integer[2];
        Integer a = 1;
        Integer b = 2;
        list.add(a);
        list.add(b);
        arr[0] = a;
        arr[1] = b;
        a = 10;
        b = 100;
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }
}
