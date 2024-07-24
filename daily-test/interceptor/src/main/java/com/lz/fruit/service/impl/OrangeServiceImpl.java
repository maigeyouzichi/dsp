package com.lz.fruit.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.fruit.entity.Orange;
import com.lz.fruit.mapper.OrangeMapper;
import com.lz.fruit.service.OrangeService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 橘子 服务实现类
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
@Service
public class OrangeServiceImpl extends ServiceImpl<OrangeMapper, Orange> implements OrangeService {

    @Override
    public Long addWithLambda(Orange orange) {
        this.save(orange);
        return orange.getId();
    }

    @Override
    public Long addWithXmlWithTime(Orange orange) {
        this.getBaseMapper().addWithXmlWithTime(orange);
        return null;
    }

    @Override
    public Long addWithXmlWithoutTime(Orange orange) {
        this.getBaseMapper().addWithXmlWithoutTime(orange);
        return null;
    }

    @Override
    public void updateWithLambdaById(Orange orange) {
        this.updateById(orange);
    }

    @Override
    public void updateWithLambdaByParam(Orange orange) {
        LambdaUpdateWrapper<Orange> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Orange::getName,orange.getName()).set(Objects.nonNull(orange.getUpdateTime()),Orange::getUpdateTime,orange.getUpdateTime())
                .eq(Orange::getId,orange.getId());
        this.update(wrapper);
    }

    @Override
    public void updateByXmlWithTime(Orange orange) {
        this.getBaseMapper().updateByXmlWithTime(orange);
    }

    @Override
    public void updateByXmlWithoutTime(Orange orange) {
        this.getBaseMapper().updateByXmlWithoutTime(orange);
    }

}
