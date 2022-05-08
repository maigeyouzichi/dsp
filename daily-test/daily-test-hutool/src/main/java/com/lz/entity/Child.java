package com.lz.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author lihao on 2022/3/28
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Child extends Parent{

    private String hobby;
}
