package com.lz.wildcard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符
 *
 * @author lihao on 2022/3/28
 */
public class WildcardTest {

    @Test
    public void test1() {
        Box<Number> box1 = new Box<>();
        box1.setFirst(100);
        showBox(box1);
    }

    @Test
    public void test002() {
        Box<Integer> box = new Box<>();
        box.setFirst(100);
        showBox(box);
    }

    private static void showBox(Box<?> box) {
        Object first = box.getFirst();
        System.out.println(first);
    }

    /**
     * 泛型通配符的上限 ? extend T
     */
    private static void showBox2(Box<? extends Number> box) {
        Number first = box.getFirst();
        System.out.println(first);
    }

    @Test
    public void test3() {
        Box<Integer> box = new Box<>();
        box.setFirst(100);
        showBox2(box);
    }

    private void showAnimal(List<? extends Cat> list) {
        for (int i = 0; i < list.size(); i++) {
            Cat cat = list.get(i);
            System.out.println(cat);
        }
    }

    @Test
    public void test4() {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<MiniCat> miniCats = new ArrayList<>();

        //showAnimal(animals); 上限在cat, 这里编译不通过
        showAnimal(cats);
        showAnimal(miniCats);
    }

    private void showCat(List<? super Cat> list) {
//        list.add(new MiniCat());
//        list.add(new Cat());
//        list.add(new Animal());
        for (int i = 0; i < list.size(); i++) {
            Cat cat = (Cat) list.get(i);
            System.out.println(cat);
        }
    }

    @Test
    public void test5() {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<MiniCat> miniCats = new ArrayList<>();

        showCat(animals);
        showCat(cats);
//        showCat(miniCats); 类型校验不通过, 下限在Cat
    }




}
