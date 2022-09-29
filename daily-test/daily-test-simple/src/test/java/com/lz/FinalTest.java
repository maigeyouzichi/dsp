package com.lz;

import com.lz.entity.Apple;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lihao on 2022/5/8
 */
@SpringBootTest
public class FinalTest {

    /**
     * 全参构造器方式
     */
    @Test
    public void test01() {
        Apple lisi = new Apple("lisi", 19);
        System.out.println(lisi);
    }

    /**
     * 反射方式
     */
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Apple> clazz = Apple.class;
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);
        // 使用构造器对象的newInstance方法初始化对象
        Object obj = constructor.newInstance("龙哥", 29);
        System.out.println(obj);
    }

    /**
     * 建造者模式
     */
    @Test
    public void test03() {
        Apple jay = Apple.builder().age(11).name("Jay").build();
    }

    @Test
    public void test04() {
        int[] arr = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if(a == b) continue;
            pq.offer(Math.abs(a-b));
        }
        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}
