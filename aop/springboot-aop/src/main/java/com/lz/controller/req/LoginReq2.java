package com.lz.controller.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lihao on 2023/4/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq2 {

    private String name;
    private Integer age;

}
