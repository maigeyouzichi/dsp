package com.lz.quickStart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 泛型类
 *
 * @author lihao on 2022/3/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Generic<T> {

    private T key;
}
