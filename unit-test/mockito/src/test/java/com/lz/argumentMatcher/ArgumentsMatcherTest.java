package com.lz.argumentMatcher;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author lihao on 2022/3/27
 */
public class ArgumentsMatcherTest {

    @Test
    public void basicTest() {
        List<Integer> list = mock(ArrayList.class);
        //参数0, 是否匹配, 底层是通过原生的equals判断的
        //when(list.get(0)).thenReturn(100);
        when(list.get(eq(0))).thenReturn(100);
        assertThat(list.get(0), equalTo(100));
        assertThat(list.get(1), nullValue());
    }

    @Test
    public void testComplex() {
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Parent.class))).thenReturn(100);
        int result = foo.function(new child1());
        assertThat(result, equalTo(100));
        int result2 = foo.function(new child2());
        assertThat(result2, equalTo(100));

        reset(foo);

        /*
            这里结果和视频不一致,Mockito.any()和Mockito.isA(),没有比较出区别,不知道是不是版本问题
         */
        when(foo.function(Mockito.any(child1.class))).thenReturn(100);
        int result3 = foo.function(new child2());
        assertThat(result3, equalTo(100));//视频里这里会断言成功,怀疑是版本问题导致的实现不一样
    }

    static class Foo {
        int function(Parent p) {
            return p.work();
        }
    }

    interface Parent {
        int work();
    }
    class child1 implements Parent {
        @Override
        public int work() {
            throw new RuntimeException();
        }
    }
    class child2 implements Parent {
        @Override
        public int work() {
            throw new RuntimeException();
        }
    }
}
