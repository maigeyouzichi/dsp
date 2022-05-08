package com.lz.wildcard;

import lombok.ToString;

/**
 * @author lihao on 2022/3/28
 */
@ToString(callSuper = true)
public class Cat extends Animal{

    public Integer age;

    public Cat(Integer age) {
        super();
        this.age = age;
    }

    public Cat(String name, Integer age) {
        super(name);
        this.age = age;
    }
}
