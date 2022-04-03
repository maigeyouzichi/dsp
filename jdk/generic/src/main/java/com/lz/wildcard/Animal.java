package com.lz.wildcard;

import lombok.ToString;

/**
 * @author lihao on 2022/3/28
 */
@ToString(callSuper = true)
public class Animal {

    public String name;

    public Animal(){}

    public Animal(String name) {
        this.name = name;
    }
}
