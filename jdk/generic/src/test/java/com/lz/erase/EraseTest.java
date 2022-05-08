package com.lz.erase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lihao
 * @date 2022-04-04 15:04
 */
@SpringBootTest
public class EraseTest {

    @Test
    public void test01() {
        Erase<Integer> erase = new Erase<>();
        Class<? extends Erase> clazz = erase.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("类型名称:"+field.getName()+":"+field.getType().getSimpleName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+":"+method.getReturnType().getSimpleName());
        }
    }

    @Test
    public void test002() {
        Class<Info> info = Info.class;
        Method[] methods01 = info.getDeclaredMethods();
        for (Method method : methods01) {
            System.out.println(method.getName()+":"+method.getReturnType().getSimpleName());
        }

        InfoImpl infoImpl = new InfoImpl();
        Class<? extends InfoImpl> implClazz = infoImpl.getClass();
        Method[] declaredMethods = implClazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName()+":"+method.getReturnType().getSimpleName());
        }
    }

}
