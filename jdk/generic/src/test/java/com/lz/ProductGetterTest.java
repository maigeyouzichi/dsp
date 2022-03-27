package com.lz;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lihao on 2022/3/27
 */
@SpringBootTest
public class ProductGetterTest {

    @Test
    public void test() {
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        String[] strProducts = {"iphone", "mac", "ipod", "kindle"};
        for (String pro : strProducts) {
            stringProductGetter.addProduct(pro);
        }

        String product = stringProductGetter.getProduct();
        System.out.println("抽中奖品: "+ product);
    }

    @Test
    public void test2() {
        ProductGetter<Integer> integerProductGetter = new ProductGetter<>();
        int[] intProducts = {1000,2000,3000};
        for (int intProduct : intProducts) {
            integerProductGetter.addProduct(intProduct);
        }

        Integer product = integerProductGetter.getProduct();
        System.out.println("抽中奖金: " + product);
    }
}
