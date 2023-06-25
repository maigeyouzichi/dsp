package com.lz.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 苹果类-- 测试final
 *
 * @author lihao on 2022/5/8
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Apple implements Serializable {

    private String name;
    private Integer age;
}
