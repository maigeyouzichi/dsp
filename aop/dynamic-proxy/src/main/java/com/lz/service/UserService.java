package com.lz.service;

/**
 * @author lihao
 */
public class UserService implements IUserService {

    public String queryUserNameById(String userId) {
        return "hi user " + userId;
    }

}
