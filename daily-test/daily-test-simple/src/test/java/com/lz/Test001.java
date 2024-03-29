package com.lz;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.lz.entity.Apple;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
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

    public int getKthMagicNumber2(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        long[] arr = {3,5,7};
        Set<Long> set = new HashSet<>();
        int rns = 1;
        for(int i=0;i<k;i++) {
            long curr = pq.poll();
            rns = (int) curr;
            for(long nu: arr) {
                long next = nu * curr;
                if (set.add(next)) pq.offer(next);
            }
        }
        return rns;
    }

    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return magic;
    }

    @Test
    public void test004() {
        String str = "  a   b       ";
        String[] s = str.split(" ");
        System.out.println(Arrays.toString(s));
        for (String s1 : s) {
            System.out.println(s1.length());
        }
    }

    @Test
    public void test005() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        ZoneId zone = ZoneId.of("+08:00");
        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(zone);
        System.out.println(zonedDateTime.format(formatter));

    }

    @Test
    public void test006() {
        // 创建LocalDateTime对象
        LocalDateTime dateTime = LocalDateTime.of(2023, 6, 8, 10, 34, 56);

        // 将LocalDateTime对象转换为ZonedDateTime对象，使用指定时区
        ZoneId zone = ZoneId.of("+08:00");
        ZonedDateTime zonedDateTime = dateTime.atZone(zone);

        // 创建DateTimeFormatter对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

        // 使用DateTimeFormatter格式化ZonedDateTime
        String formattedDateTime = zonedDateTime.format(formatter);

        // 输出格式化后的字符串
        System.out.println(formattedDateTime);
    }

    @Test
    public void test007() {
        String str = "1476002653514371072";
        System.out.println(str.length());
    }

    @Test
    public void test008() {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println((id+"").length());
        System.out.println(id);
    }

    @Test
    public void test009() {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.putIfAbsent(1, 100));
        System.out.println(map.putIfAbsent(1, 2));
        System.out.println(map.putIfAbsent(1,3));
        System.out.println(map.get(1));
    }

    @Test
    public void test010() {
        ArrayList<Integer> top = new ArrayList<>();
        ArrayList<Integer> nottop = new ArrayList<>();
        top.add(2);
        top.add(4);
        nottop.add(3);
        nottop.add(2);
        top.addAll(nottop);
        System.out.println(top);
    }

    @Test
    public void test011() {
        List<Apple> apples = new ArrayList<>();
        apples.add(Apple.builder().age(10).build());
        apples.add(Apple.builder().age(11).build());
        apples.add(Apple.builder().age(21).build());
        apples.add(Apple.builder().age(22).build());
        System.out.println(apples);
        List<Apple> applesA = apples.stream().filter(e -> e.getAge() > 20).peek(e -> e.setName("Jack")).collect(Collectors.toList());
        System.out.println(applesA);
        List<Apple> applesB = apples.stream().filter(e -> e.getAge() < 20).collect(Collectors.toList());
        System.out.println(applesB);
        applesA.addAll(applesB);
        System.out.println(applesA);
    }

    @Test
    public void test012() {
        System.out.println(1534236469);
        System.out.println(Integer.MAX_VALUE);
    }
}
