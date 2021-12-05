package com.lz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lz.entity.Users;
import com.lz.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JdbcUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 根据username查询出该⽤户的所有信息，封装成UserDetails类型的对象返回，⾄于密码，框架会⾃动匹配
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername,username);
        Users users = usersMapper.selectOne(wrapper);
        return new User(users.getUsername(), users.getPassword(), new ArrayList<>());
    }
}