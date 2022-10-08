package com.lz;

import com.lz.entity.Apple;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void test05() {
        System.out.println(multiply("11", "11"));
    }

    //统计数组中位数为偶数的数字的个数
    private int countNum(int[] arr) {
        int count= 0;
        for(int nu: arr) {
            int tmp = 0;
            while (nu > 0) {
                nu /=10;
                tmp++;
            }
            if((tmp&1) == 0) count++;
        }
        return count;
    }

    public String multiply(String num1, String num2) {
        long m = convertStr2Long(num1);
        long n = convertStr2Long(num2);
        List<Long> list = new ArrayList<>();
        int k = 1;
        while(n >0) {
            list.add(n%10 * m * k);
            n /= 10;
            k *= 10;
        }
        StringBuilder sb = new StringBuilder();
        long lastNum = list.get(list.size() - 1);
        long jw = 0;
        while(lastNum > 0) {
            long tmp = 0;
            for(int i=0;i<list.size();i++) {
                tmp += list.get(i)%10;
                list.set(i, list.get(i)/10);
            }
            sb.append((tmp+jw)%10);
            jw = (tmp+jw)/10;
            lastNum /= 10;
        }
        return sb.reverse().toString();
    }

    private long convertStr2Long(String str) {
        char[] chars = str.toCharArray();
        long rns = 0;
        long k= 1;
        for(int i =chars.length-1;i>=0;i--) {
            long tmp = chars[i] - '0';
            rns += tmp * k;
            k *= 10;
        }
        return rns;
    }
}
