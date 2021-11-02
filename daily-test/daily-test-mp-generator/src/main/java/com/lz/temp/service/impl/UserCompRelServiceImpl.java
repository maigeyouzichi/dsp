package com.lz.temp.service.impl;

import com.lz.temp.entity.UserCompRel;
import com.lz.temp.mapper.UserCompRelMapper;
import com.lz.temp.service.UserCompRelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和挂靠公司关联表 服务实现类
 * </p>
 *
 * @author lihao
 * @since 2021-11-02
 */
@Service
public class UserCompRelServiceImpl extends ServiceImpl<UserCompRelMapper, UserCompRel> implements UserCompRelService {

}
