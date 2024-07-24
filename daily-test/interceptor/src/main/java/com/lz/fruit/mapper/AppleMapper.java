package com.lz.fruit.mapper;

import com.lz.fruit.entity.Apple;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 苹果表 Mapper 接口
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
public interface AppleMapper extends BaseMapper<Apple> {

    void addWithXmlWithoutTime(@Param("apple") Apple apple);

    void addWithXmlWithTime(@Param("apple") Apple apple);

    void updateByXmlWithTime(@Param("apple") Apple apple);

    void updateByXmlWithoutTime(@Param("apple") Apple apple);
}
