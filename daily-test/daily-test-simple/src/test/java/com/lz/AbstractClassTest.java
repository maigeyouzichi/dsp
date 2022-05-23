package com.lz;

import com.lz.abstractPackage.AbstractPig;
import com.lz.abstractPackage.BigPig;
import com.lz.abstractPackage.SmallPig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihao on 2022/5/22
 */
@SpringBootTest
public class AbstractClassTest {

    @Test
    public void test01(){
        AbstractPig bigPig = new BigPig();
        bigPig.setAge("11");
        bigPig.setName("Jack");
        bigPig.showMessage();
        System.out.println(bigPig.getAge());
        System.out.println(bigPig.getName());
    }

    @Test
    public void test02(){
        AbstractPig bigPig = new BigPig("11","Java");
        bigPig.showMessage();
        System.out.println(bigPig.getAge());
        System.out.println(bigPig.getName());
    }

    @Test
    public void test03() {
        AbstractPig bigPig = new BigPig("11","Java");
        AbstractPig smallPig = new SmallPig("12","Kotlin");

        List<AbstractPig> list = new ArrayList<>();
        list.add(bigPig);
        list.add(smallPig);
        for (AbstractPig pig : list) {
            System.out.println(pig.getName());
            pig.showMessage();
        }
    }
}
