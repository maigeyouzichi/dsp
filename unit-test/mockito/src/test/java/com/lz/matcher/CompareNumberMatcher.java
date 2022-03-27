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
