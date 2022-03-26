package com.lz.quickstart;

import com.lz.common.Account;
import com.lz.common.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

/**
 * mock方式1
 * @author lihao on 2022/3/26
 */
@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    /**
     * 返回默认
     */
    @Test
    public void testMock() {
        AccountDao accountDao = mock(AccountDao.class);
        Account account = accountDao.findAccount("x", "y");
        System.out.println(account);
    }
    /**
     * 返回对象+方法签名的字符串
     */
    @Test
    public void testMock2() {
        AccountDao accountDao = mock(AccountDao.class, Mockito.RETURNS_SMART_NULLS);
        Account account = accountDao.findAccount("x", "y");
        System.out.println(account);
    }
}
