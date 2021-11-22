package com.lz;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lihao
 * @date 2021-11-22 12:38
 */
public class TestLists {

    @Test
    public void testLists() {
        List<Integer> objects = Collections.singletonList(1);
        ArrayList<Integer> integers = Lists.newArrayList(objects);
        List<Integer> list = Collections.singletonList(1);
        boolean b = integers.addAll(list);
        System.out.println(integers);
    }

    @Test
    public void testLists02() {
        List<Integer> objects = Collections.singletonList(1);
        List<Integer> objects1 = Lists.newArrayList(1);
        boolean b = objects.addAll(objects1);
    }

    @Test
    public void testLists03() {
        ArrayList<Object> objects = Lists.newArrayList(Lists.newArrayList());
        ArrayList<Object> integers = Lists.newArrayList(Lists.newArrayList(1));
        boolean b = objects.addAll(integers);
        System.out.println(objects);
    }
}
