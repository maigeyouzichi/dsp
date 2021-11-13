package com.lz.service;

import com.lz.entity.RResume;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihao
 * @since 2021-11-07
 */
public interface RResumeService extends IService<RResume> {

    Integer findDefaultResumeStateByUserId(Long userId);

}
