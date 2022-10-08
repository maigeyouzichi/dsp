package com.lz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Apple implements Comparable<Apple> {
    private Integer id;
    private Integer weight;

    private Integer country;

    @Override
    public int compareTo(Apple o) {
        return this.weight - o.getWeight();
    }
}
