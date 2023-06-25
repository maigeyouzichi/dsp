package com.lz;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class TestDTO {

    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9!#$&*+=\\-\\s._]*$" ,message = "valid name, please modify your name !")
    private String name;
}
