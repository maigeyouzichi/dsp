package com.lz.quickstart;

import com.lz.common.Account;
import com.lz.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * mock方式2
 * @author lihao on 2022/3/26
 */
public class MockByAnnotationTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)//不加answer就会返回null
    private AccountDao accountDao;

    @Test
    public void testMock() {
        Account account = accountDao.findAccount("x", "y");
        System.out.println(account);
    }
}
