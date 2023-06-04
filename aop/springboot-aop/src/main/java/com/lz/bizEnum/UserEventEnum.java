package com.lz.bizEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户事件枚举
 * @author lihao on 2023/4/15
 */
@AllArgsConstructor
@Getter
public enum UserEventEnum {

    LOGIN(0,"login");

    private final Integer code;
    private final String name;
}
