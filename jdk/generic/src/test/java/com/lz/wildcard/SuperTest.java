package com.lz.wildcard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author lihao
 * @date 2022-04-04 00:11
 */
@SpringBootTest
public class SuperTest {

    /**
     * 通过这个例子可以很好的理解  ? super T
     * 1, TreeSet本身规定了具体的类型
     * 2, 不同的comparator的传入,表示用那个字段进行比较
     * 3, 这样以来,treeSet中传入的元素必须都是Cat本身,不会是其子类,否则某些对象缺少字段
     * 4, 对于比较字段, 只能是cat中的字段或者其父类中的字段,所以这里Comparator必须是 ? super T
     */
    @Test
    public void test01() {
        TreeSet<Cat> treeSet = new TreeSet<>(new Comparator1());
        treeSet.add(new Cat("jerry",20));
        treeSet.add(new Cat("frank",35));
        treeSet.add(new Cat("amy",22));
        treeSet.add(new Cat("jim",15));

        for (Cat cat : treeSet) {
            System.out.println(cat);
        }
    }

}

class Comparator1 implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Comparator2 implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.age - o2.age;
    }
}

class Comparator3 implements Comparator<MiniCat> {
    @Override
    public int compare(MiniCat o1, MiniCat o2) {
        return o1.level - o2.level;
    }
}
