package com.lz.service.impl;

import com.lz.entity.RResume;
import com.lz.mapper.RResumeMapper;
import com.lz.service.RResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author lihao
 * @since 2021-11-07
 */
@Service
public class RResumeServiceImpl extends ServiceImpl<RResumeMapper, RResume> implements RResumeService {

    @Override
    public Integer findDefaultResumeStateByUserId(Long userId) {
        RResume resume = this.getById(userId);
        return resume.getIsOpenResume();
    }
}
