package com.lz.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.lz.matcher.CompareNumberMatcher.gt;
import static com.lz.matcher.CompareNumberMatcher.lt;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * 自定义Matcher
 * 自定实现gt lt 大于小于
 * @author lihao on 2022/3/27
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomizedMatcher {

    @Test
    public void test() {
        assertThat(10 , equalTo(10));
        //正常会这么写
        assertThat(10 > 9, equalTo(true));
        assertThat(10, gt(9));
        assertThat(10 ,lt(12));
    }

}
