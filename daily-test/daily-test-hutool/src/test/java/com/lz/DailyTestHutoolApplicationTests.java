package com.lz;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.lz.entity.Child;
import com.lz.entity.Parent;
import com.lz.enums.AlarmTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@SpringBootTest
class DailyTestHutoolApplicationTests {

    @Test
    void contextLoads() {

        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(DateUtil.format(now.atStartOfDay(), DatePattern.NORM_DATETIME_PATTERN));
    }

    @Test
    void test001(){

        LocalDate today = LocalDate.now();
        LocalDate date = today.plusDays(2L);
        System.out.println(DateUtil.format(today.atStartOfDay(), DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(date.atStartOfDay(), DatePattern.NORM_DATETIME_PATTERN));

        System.out.println(Duration.between(today.atStartOfDay(), date.atStartOfDay()).toDays());
    }


    @Test
    void test002() {
        long[] longs = new long[4];
        System.out.println(Arrays.toString(longs));
    }

    @Test
    void test003() {
        System.out.println(AlarmTypeEnum.OVER_SPEED.name());
        System.out.println(AlarmTypeEnum.OVER_SPEED.toString());
        System.out.println(AlarmTypeEnum.OVER_SPEED.getValue());

        AlarmTypeEnum over_speed = AlarmTypeEnum.valueOf("OVER_SPEED");
        String value = over_speed.getValue();
        System.out.println(value);
    }

    /**
     * 测试随机数
     * hello
     */
    @Test
    void test004() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Math.round(Math.random()*50));
        }
    }


    @Test
    void test005() {
        Child child = new Child();
        child.setId(100);
        child.setName("Java");
        child.setHobby("coding");
        System.out.println(child.toString());

        Child child1 = new Child();
        child1.setId(101);
        child1.setName("Kotlin");
        child1.setHobby("coding");

        System.out.println(Objects.equals(child,child1));
    }
}
