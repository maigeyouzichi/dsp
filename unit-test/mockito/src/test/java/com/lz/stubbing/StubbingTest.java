package com.lz.stubbing;

import com.lz.common.StubbingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * stubbing
 *
 * @author lihao on 2022/3/26
 */
@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

    private List<String> list;

    @Before
    public void init() {
        this.list = mock(ArrayList.class);
    }

    @Test
    public void howToUseStubbing() {
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));

        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();//如果没有抛出异常就执行手动失败
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void howToStubbingVoidMethod() {
        //执行clear()的时候啥也不做
        doNothing().when(list).clear();
        list.clear();
        list.clear();
        //断言 -> clear()方法是不是执行了2次
        verify(list, times(2)).clear();

        //执行clear()的时候抛出异常
        doThrow(RuntimeException.class).when(list).clear();

        try {
            list.clear();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void stubbingDoReturn() {
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);
        assertThat(list.get(0),equalTo("first"));
        assertThat(list.get(1),equalTo("second"));
    }

    @Test
    public void iterateSubbing() {
//        when(list.size()).thenReturn(1,2,3,4);
        when(list.size()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);//和上面等价
        assertThat(list.size(),equalTo(1));
        assertThat(list.size(),equalTo(2));
        assertThat(list.size(),equalTo(3));
        assertThat(list.size(),equalTo(4));
        assertThat(list.size(),equalTo(4));
    }

    @Test
    public void stubbingWithAnswer() {
        when(list.get(anyInt())).thenAnswer(mock -> {
            Integer index = mock.getArgument(0, Integer.class);
            return String.valueOf(index * 10);
        });

        assertThat(list.get(0), equalTo("0"));
        assertThat(list.get(99), equalTo("990"));
    }


    @Test
    public void stubbingWithRealCall() {
        StubbingService stubbingService = mock(StubbingService.class);
        when(stubbingService.getS()).thenReturn("Alex");
        when(stubbingService.getI()).thenCallRealMethod();
        assertThat(stubbingService.getS(), equalTo("Alex"));
        assertThat(stubbingService.getI(), equalTo(10));
    }

    @After
    public void destroy() {
        reset(this.list);
    }
}
