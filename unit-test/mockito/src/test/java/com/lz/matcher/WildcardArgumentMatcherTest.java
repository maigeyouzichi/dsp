package com.lz.matcher;

import com.lz.common.SimpleService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author lihao on 2022/3/27
 */
@RunWith(MockitoJUnitRunner.class)
public class WildcardArgumentMatcherTest {

    @Mock
    private SimpleService simpleService;

    @Test
    public void wildcardMethod1() {
        when(simpleService.method1(anyInt(), anyString(), anyCollection(), isA(Serializable.class))).thenReturn(100);
        int result = simpleService.method1(1, "Alex", Collections.emptySet(), "Mockito");
        assertThat(result, equalTo(100));
    }

    /**
     * 特殊值匹配,需要在特殊值上增加 eq() 保证语法校验通过
     */
    @Test
    public void wildcardMethod1WithSpc() {
        when(simpleService.method1(anyInt(), anyString(), anyCollection(), isA(Serializable.class))).thenReturn(-1);//这个如果写在下面,会覆盖上面的stubbing
        when(simpleService.method1(anyInt(), eq("Alex"), anyCollection(), isA(Serializable.class))).thenReturn(100);
        when(simpleService.method1(anyInt(), eq("Jay"), anyCollection(), isA(Serializable.class))).thenReturn(100);
        int result = simpleService.method1(1, "Alex", Collections.emptySet(), "Mockito");
        assertThat(result, equalTo(100));
        int result2 = simpleService.method1(1, "Jay", Collections.emptySet(), "Mockito");
        assertThat(result2, equalTo(100));

        int result3 = simpleService.method1(1, "anyString", Collections.emptySet(), "Mockito");
        assertThat(result3, equalTo(-1));
    }

    /**
     * 意思大概是如果使用通配那么就都得使用, 如果掺杂了确定的值, 可以用eq()修饰
     */
    @Test
    public void wildcardMethod2() {
        doNothing().when(simpleService).method2(anyInt(), anyString(), anyCollection(), isA(Serializable.class));
        simpleService.method2(1, "Alex", Collections.emptySet(), "Mockito");
        verify(simpleService, times(1)).method2(1, "Alex", Collections.emptySet(), "Mockito");
        verify(simpleService, times(1)).method2(anyInt(),eq("Alex"),anyCollection(),isA(Serializable.class));
    }


    /**
     * 良好的编码习惯: 清除stubbing
     */
    @After
    public void destroy() {
        reset(simpleService);
    }
}
