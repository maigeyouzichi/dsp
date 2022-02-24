package com.lz.senior.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lihao on 2022/2/24
 */
@SuppressWarnings("all")
public class CopyOnWriteArrayListTest {

    static List list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        list.add("hello");
        list.add("alibaba");
        list.add("can");
        list.add("you");
        list.add("give me a offer");
        Iterator iterator = list.iterator();
        Thread threadOne = new Thread(() -> {
            list.set(1, "hi");
            list.remove(2);
        });
        threadOne.start();
        threadOne.join();
        while (iterator.hasNext()) System.out.println(iterator.next());
        iterator = list.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
