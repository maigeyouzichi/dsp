package com.lz.abstractPackage;

/**
 * @author lihao on 2022/5/22
 */
public class BigPig extends AbstractPig{

    public BigPig() {}

    public BigPig(String age, String name) {
        super(age, name);
    }

    @Override
    public void showMessage() {
        System.out.println("我是大猪");
    }
}
