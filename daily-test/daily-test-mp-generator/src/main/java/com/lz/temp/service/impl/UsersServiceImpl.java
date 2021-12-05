package com.lz.temp.service.impl;

import com.lz.temp.entity.Users;
import com.lz.temp.mapper.UsersMapper;
import com.lz.temp.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihao
 * @since 2021-12-05
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
