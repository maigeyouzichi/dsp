package com.lz.quickstart;

import com.lz.common.Account;
import com.lz.common.AccountDao;
import com.lz.common.Dog;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 多层次mock, 对于要求mock的对象, 返回的结构也进行mock
 * @author lihao on 2022/3/26
 */
public class DeepMockTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private AccountDao accountDao;

    @Test
    public void deepMock() {
        Account account = accountDao.findAccount("x", "y");
        Dog dog = account.foo();
        String yell = dog.yell();
        System.out.println(yell);
    }
}
