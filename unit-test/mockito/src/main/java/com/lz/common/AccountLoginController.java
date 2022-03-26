package com.lz.common;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * controller
 *
 * @author lihao on 2022/3/26
 */
@Slf4j
public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        final String userName = request.getParameter("userName");
        final String password = request.getParameter("password");
        try {
            Account account = accountDao.findAccount(userName, password);
            return Objects.isNull(account) ? "/login.html" : "/index.html";
        } catch (Exception e) {
            log.error("报错505: ", e);
            return "505";
        }

    }
}
