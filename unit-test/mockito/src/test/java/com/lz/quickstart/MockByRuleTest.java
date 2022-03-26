package com.lz.quickstart;

import com.lz.common.Account;
import com.lz.common.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

/**
 * mock方式3
 * @author lihao on 2022/3/26
 */
public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testMock() {
        AccountDao accountDao1 = mock(AccountDao.class);
        Account account = accountDao1.findAccount("x", "y");
        System.out.println(account);
    }

    @Mock
    private AccountDao accountDao;

    /**
     * 甚至可以使用@Mock
     */
    @Test
    public void testMock2() {
        Account account = accountDao.findAccount("x", "y");
        System.out.println(account);
    }
}
