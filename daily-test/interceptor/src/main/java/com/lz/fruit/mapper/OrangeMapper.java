package com.lz.fruit.mapper;

import com.lz.fruit.entity.Orange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 橘子 Mapper 接口
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
public interface OrangeMapper extends BaseMapper<Orange> {

    void addWithXmlWithoutTime(@Param("orange") Orange orange);

    void addWithXmlWithTime(@Param("orange") Orange orange);

    void updateByXmlWithTime(@Param("orange")Orange orange);

    void updateByXmlWithoutTime(@Param("orange") Orange orange);
}
