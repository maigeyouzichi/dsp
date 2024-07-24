package com.lz.fruit.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.fruit.entity.Apple;
import com.lz.fruit.mapper.AppleMapper;
import com.lz.fruit.service.AppleService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 苹果表 服务实现类
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
@Service
public class AppleServiceImpl extends ServiceImpl<AppleMapper, Apple> implements AppleService {

    @Override
    public Long addWithLambda(Apple apple) {
        this.save(apple);
        return apple.getId();
    }

    @Override
    public Long addWithXmlWithTime(Apple apple) {
        this.getBaseMapper().addWithXmlWithTime(apple);
        return null;
    }

    @Override
    public Long addWithXmlWithoutTime(Apple apple) {
        this.getBaseMapper().addWithXmlWithoutTime(apple);
        return null;
    }

    @Override
    public void updateWithLambdaById(Apple apple) {
        this.updateById(apple);
    }

    @Override
    public void updateWithLambdaByParam(Apple apple) {
        LambdaUpdateWrapper<Apple> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Apple::getName,apple.getName()).set(Objects.nonNull(apple.getUpdateTime()),Apple::getUpdateTime,apple.getUpdateTime())
                .eq(Apple::getId,apple.getId());
        this.update(wrapper);
    }

    @Override
    public void updateByXmlWithTime(Apple apple) {
        this.getBaseMapper().updateByXmlWithTime(apple);
    }

    @Override
    public void updateByXmlWithoutTime(Apple apple) {
        this.getBaseMapper().updateByXmlWithoutTime(apple);
    }
}
