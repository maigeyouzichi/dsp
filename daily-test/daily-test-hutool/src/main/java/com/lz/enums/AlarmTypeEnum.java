package com.lz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 报警类型枚举
 * @author lihao
 * @date 2021-10-25 17:16
 */
@Getter
@AllArgsConstructor
public enum AlarmTypeEnum {

    /**疲劳驾驶*/
    TIRED_DRIVING("疲劳驾驶"),
    /**超速*/
    OVER_SPEED("超速");

    private String value;
}
