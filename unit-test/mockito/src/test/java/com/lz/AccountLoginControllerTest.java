package com.lz;

import com.lz.controller.AccountLoginController;
import com.lz.dao.AccountDao;
import com.lz.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author lihao on 2022/3/26
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;

    private HttpServletRequest request;

    private AccountLoginController loginController;

    @Before
    public void setUp() {
        accountDao = Mockito.mock(AccountDao.class);
        request = Mockito.mock(HttpServletRequest.class);
        loginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        when(request.getParameter("userName")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account);

        assertThat(loginController.login(request), equalTo("/index.html"));
    }

    @Test
    public void testLoginFail() {
        when(request.getParameter("userName")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(null);

        assertThat(loginController.login(request), equalTo("/login.html"));
    }

    @Test
    public void testLogin505() {
        when(request.getParameter("userName")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenThrow(UnsupportedOperationException.class);

        assertThat(loginController.login(request), equalTo("505"));
    }



}
