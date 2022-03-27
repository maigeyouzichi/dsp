package com.lz.matcher;


import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.TestFactory;

/**
 * 大于
 *
 * @author lihao on 2022/3/27
 */
public class CompareNumberMatcher<T extends Number> extends BaseMatcher<T> {

    private final T operand;
    private final Compare<T> COMPARE;

    public CompareNumberMatcher(T operand, boolean great) {
        this.operand = operand;
        this.COMPARE = new DefaultNumberCompare<>(great);
    }

    /**
     * 外部的assertThat方法只关系这个方法的返回值是true还是false, true:断言成功 false:断言失败
     * 置于怎么实现, 随你实现, 两个分别是: 1, 传入的actual 2,this的field,构造器中传入.
     */
    @Override
    public boolean matches(Object actual) {
        return this.COMPARE.compare(operand,(T) actual);
    }

    @TestFactory
    public static <T extends Number> CompareNumberMatcher<T> gt(T operand) {
        return new CompareNumberMatcher<>(operand,true);
    }
    @TestFactory
    public static <T extends Number> CompareNumberMatcher<T> lt(T operand) {
        return new CompareNumberMatcher<>(operand,false);
    }



    @Override
    public void describeTo(Description description) {
        description.appendText("compare two number failed.");
    }
}
