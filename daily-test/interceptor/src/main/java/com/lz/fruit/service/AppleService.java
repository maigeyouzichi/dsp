package com.lz.fruit.service;

import com.lz.fruit.entity.Apple;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 苹果表 服务类
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
public interface AppleService extends IService<Apple> {


    Long addWithLambda(Apple apple);

    Long addWithXmlWithTime(Apple apple);

    Long addWithXmlWithoutTime(Apple apple);

    void updateWithLambdaById(Apple apple);

    void updateWithLambdaByParam(Apple apple);

    void updateByXmlWithTime(Apple apple);

    void updateByXmlWithoutTime(Apple apple);
}
