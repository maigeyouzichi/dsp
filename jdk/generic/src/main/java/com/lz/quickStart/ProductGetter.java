package com.lz.quickStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lihao on 2022/3/27
 */
@SuppressWarnings("all")
public class ProductGetter<T> {

    Random random = new Random();

    //奖品
    private T product;

    //奖品池
    private List<T> list = new ArrayList<>();

    //添加奖品
    public void addProduct(T t) {
        list.add(t);
    }

    //这种不是泛型方法,只是普通方法
    //抽奖
    public T getProduct() {
        product = list.get(random.nextInt(list.size()));
        return product;
    }

    /**
     * 这就是一个泛型方法,声明<T>, 调用方法时指定类型, 而不是声明类的时候,调用方法时指定的类型允许和声明类时不一致
     *
     * @param list 参数
     * @param <E>  泛型标识,具体类型,由调用方法的时候来指定
     * @return
     */
    public <T> T getProduct(ArrayList<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    public static <T, E, V> void printType(T t, E e, V v) {
        System.out.println(t + "\t" + t.getClass().getSimpleName());
        System.out.println(e + "\t" + e.getClass().getSimpleName());
        System.out.println(v + "\t" + v.getClass().getSimpleName());
    }

    public static <E> void print(E... e) {
        for (E e1 : e) {
            System.out.println(e1);
        }
    }
}
