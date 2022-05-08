package com.lz.wildcard;

import lombok.ToString;

/**
 * @author lihao on 2022/3/28
 */
@ToString(callSuper = true)
public class MiniCat extends Cat {

    public Integer level;

    public MiniCat(Integer age, Integer level) {
        super(age);
        this.level = level;
    }

    public MiniCat(String name, Integer age, Integer level) {
        super(name, age);
        this.level = level;
    }

}
