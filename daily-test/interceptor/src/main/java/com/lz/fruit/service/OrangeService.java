package com.lz.fruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lz.fruit.entity.Orange;

/**
 * <p>
 * 橘子 服务类
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
public interface OrangeService extends IService<Orange> {

    Long addWithLambda(Orange orange);

    Long addWithXmlWithTime(Orange orange);

    Long addWithXmlWithoutTime(Orange orange);

    void updateWithLambdaById(Orange orange);

    void updateWithLambdaByParam(Orange orange);

    void updateByXmlWithTime(Orange orange);

    void updateByXmlWithoutTime(Orange orange);

}
