package com.lz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author lihao
 * @date 2021-11-04 12:46
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private String age;
    private Date birthday;
}
