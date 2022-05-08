package com.lz.matcher;

public interface Compare<T extends Number> {
    boolean compare(T operand, T actual);
}