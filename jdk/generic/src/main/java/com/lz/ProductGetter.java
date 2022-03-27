package com.lz;

import javax.lang.model.element.VariableElement;
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

    //抽奖
    public T getProduct() {
        product = list.get(random.nextInt(list.size()));
        return product;
    }
}
