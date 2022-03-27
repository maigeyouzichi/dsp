package com.lz;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试泛型
 *
 * @author lihao on 2022/3/27
 */
@SpringBootTest
public class GenericTest {

    @Test
    public void test01() {
        //指定String
        Generic<String> generic = new Generic<>("Hello");
        System.out.println(generic);

        //指定Integer
        Generic<Integer> integerGeneric = new Generic<>(100);
        Integer key = integerGeneric.getKey();
        System.out.println(key);
        //不指定类型,但是实际为String
        Generic obj = new Generic(12.3f);
        Object key1 = obj.getKey();//没有指定泛型,认定为object

        System.out.println("------ get class ----------");

        System.out.println(generic.getKey().getClass());
        System.out.println(key.getClass());
        System.out.println(key1.getClass());

        System.out.println(generic.getClass());
        System.out.println(integerGeneric.getClass());
        System.out.println(obj.getClass());

        System.out.println("Class 对象地址是否相同: " + (generic.getClass() == integerGeneric.getClass()));
    }
}
