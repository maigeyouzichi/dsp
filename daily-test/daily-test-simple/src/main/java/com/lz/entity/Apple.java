package com.lz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 苹果类-- 测试final
 *
 * @author lihao on 2022/5/8
 */
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Apple implements Serializable {

    private final String name;
    private final Integer age;
}
