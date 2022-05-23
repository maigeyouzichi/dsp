package com.lz.abstractPackage;

/**
 * @author lihao on 2022/5/22
 */
public class SmallPig extends AbstractPig{

    public SmallPig(){}

    public SmallPig(String age, String name) {
        super(age, name);
    }

    @Override
    public void showMessage() {
        System.out.println("我是小猪");
    }
}
