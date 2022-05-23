package com.lz.abstractPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 抽象的猪
 *
 * @author lihao on 2022/5/22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractPig {

    private String age;
    private String name;

    public abstract void showMessage();
}
