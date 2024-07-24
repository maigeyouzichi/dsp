package com.lz.fruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lz.fruit.entity.Strawberry;

/**
 * <p>
 * 草莓 服务类
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
public interface StrawberryService extends IService<Strawberry> {

    Long addWithLambda(Strawberry strawberry);

    Long addWithXmlWithTime(Strawberry strawberry);

    Long addWithXmlWithoutTime(Strawberry strawberry);

    void updateWithLambdaById(Strawberry strawberry);

    void updateWithLambdaByParam(Strawberry strawberry);

    void updateByXmlWithTime(Strawberry strawberry);

    void updateByXmlWithoutTime(Strawberry strawberry);

}
