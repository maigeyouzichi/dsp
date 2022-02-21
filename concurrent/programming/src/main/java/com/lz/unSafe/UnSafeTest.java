package com.lz.unSafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author lihao on 2022/2/21
 */
public class UnSafeTest {

    static final Unsafe UN_SAFE;
    static final long STATE_OFFSET;
    public long state = 0;

    static {
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置权限
            field.setAccessible(true);
            //获取该变量的值
            UN_SAFE = (Unsafe) field.get(null);
            //获取state在TestUnsafe中的偏移量
            STATE_OFFSET = UN_SAFE.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));
        }catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnSafeTest test = new UnSafeTest();
        System.out.println(test.state);
        //找到test对象对应偏移量的值,同预计比较,如果等于预期,更新为新值
        boolean success = UN_SAFE.compareAndSwapLong(test, STATE_OFFSET, 0, 1);
        System.out.println(success);
        System.out.println(test.state);
    }
}
