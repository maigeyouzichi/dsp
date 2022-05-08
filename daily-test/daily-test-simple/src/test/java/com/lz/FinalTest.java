package com.lz;

import com.lz.entity.Apple;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
}
