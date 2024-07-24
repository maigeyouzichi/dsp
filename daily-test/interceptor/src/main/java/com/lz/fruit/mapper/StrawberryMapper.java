package com.lz.fruit.mapper;

import com.lz.fruit.entity.Strawberry;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 草莓 Mapper 接口
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
public interface StrawberryMapper extends BaseMapper<Strawberry> {

    void addWithXmlWithoutTime(@Param("strawberry") Strawberry strawberry);

    void addWithXmlWithTime(@Param("strawberry") Strawberry strawberry);

    void updateByXmlWithTime(@Param("strawberry")Strawberry strawberry);

    void updateByXmlWithoutTime(@Param("strawberry") Strawberry strawberry);
}
