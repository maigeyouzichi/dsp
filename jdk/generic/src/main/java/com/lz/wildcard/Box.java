package com.lz.wildcard;

import lombok.Data;

/**
 * @author lihao on 2022/3/28
 */
@Data
public class Box<E> {

    private E first;
}
