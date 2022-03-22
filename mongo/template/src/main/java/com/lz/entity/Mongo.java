package com.lz.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author lihao
 * @date 2022-03-22 18:25
 */
@Data
public class Mongo {

    @MongoId
    private String id;
    private Integer age;
    private String name;
    private String language;
    private Integer rank;
}
