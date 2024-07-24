package com.lz.fruit.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.fruit.entity.Strawberry;
import com.lz.fruit.mapper.StrawberryMapper;
import com.lz.fruit.service.StrawberryService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 草莓 服务实现类
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
@Service
public class StrawberryServiceImpl extends ServiceImpl<StrawberryMapper, Strawberry> implements StrawberryService {

    @Override
    public Long addWithLambda(Strawberry strawberry) {
        this.save(strawberry);
        return strawberry.getId();
    }

    @Override
    public Long addWithXmlWithTime(Strawberry strawberry) {
        this.getBaseMapper().addWithXmlWithTime(strawberry);
        return null;
    }

    @Override
    public Long addWithXmlWithoutTime(Strawberry strawberry) {
        this.getBaseMapper().addWithXmlWithoutTime(strawberry);
        return null;
    }

    @Override
    public void updateWithLambdaById(Strawberry strawberry) {
        this.updateById(strawberry);
    }

    @Override
    public void updateWithLambdaByParam(Strawberry strawberry) {
        LambdaUpdateWrapper<Strawberry> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Strawberry::getName,strawberry.getName()).set(Objects.nonNull(strawberry.getUpdateTime()),Strawberry::getUpdateTime,strawberry.getUpdateTime())
                .eq(Strawberry::getId,strawberry.getId());
        this.update(wrapper);
    }

    @Override
    public void updateByXmlWithTime(Strawberry strawberry) {
        this.getBaseMapper().updateByXmlWithTime(strawberry);
    }

    @Override
    public void updateByXmlWithoutTime(Strawberry strawberry) {
        this.getBaseMapper().updateByXmlWithoutTime(strawberry);
    }
}
