package com.lz.derive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 派生
 *
 * @author lihao on 2022/3/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parent<E> {
    private E value;
}
