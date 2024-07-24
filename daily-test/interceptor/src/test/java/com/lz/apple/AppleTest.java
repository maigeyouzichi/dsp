package com.lz.apple;

import com.lz.InterceptorApplication;
import com.lz.fruit.entity.Apple;
import com.lz.fruit.service.AppleService;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试Apple实体
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InterceptorApplication.class)
public class AppleTest {

    @Resource
    private AppleService appleService;

    /**
     * 测试lambda新增 -- 带时间参数
     */
    @Test
    public void addWithLambdaWithTime() {
        Apple apple = Apple.builder().name("one").createTime(System.currentTimeMillis()).updateTime(System.currentTimeMillis()).build();
        appleService.addWithLambda(apple);
    }

    /**
     * 测试lambda新增 -- 不带时间参数
     */
    @Test
    public void addWithLambdaWithoutTime() {
        Apple apple = Apple.builder().name("one").build();
        appleService.addWithLambda(apple);
    }

    /**
     * 测试xml新增 -- 带时间参数
     */
    @Test
    public void addWithXmlWithTime() {
        Apple apple = Apple.builder().name("one").createTime(System.currentTimeMillis()).updateTime(System.currentTimeMillis()).build();
        appleService.addWithXmlWithTime(apple);
    }

    /**
     * 测试xml新增 -- 不带时间参数
     */
    @Test
    public void addWithXmlWithoutTime() {
        Apple apple = Apple.builder().name("one").createTime(System.currentTimeMillis()).updateTime(System.currentTimeMillis()).build();
        appleService.addWithXmlWithoutTime(apple);
    }

    /**
     * 测试lambda 实体修改 -- 带时间参数
     */
    @Test
    public void updateWithLambdaAndEntityWithTime() {
        Apple apple = Apple.builder().id(1L).name("").updateTime(System.currentTimeMillis()).build();
        appleService.updateWithLambdaById(apple);
    }

    /**
     * 测试lambda 实体修改 -- 不带时间参数
     */
    @Test
    public void updateWithLambdaAndEntityWithoutTime() {
        Apple apple = Apple.builder().id(1L).name("").build();
        appleService.updateWithLambdaById(apple);
    }

    /**
     * 测试lambda 修改 -- 带时间参数
     */
    @Test
    public void updateWithLambdaParamWithTime() {
        Apple apple = Apple.builder().id(1L).name("").createTime(System.currentTimeMillis()).updateTime(System.currentTimeMillis()).build();
        appleService.updateWithLambdaByParam(apple);
    }

    /**
     * 测试lambda 修改 -- 不带时间参数
     */
    @Test
    public void updateWithLambdaParamWithoutTime() {
        Apple apple = Apple.builder().id(1L).name("").build();
        appleService.updateWithLambdaByParam(apple);
    }

    /**
     * 测试xml修改 -- 带时间参数
     */
    @Test
    public void updateWithXmlWithTime() {
        Apple apple = Apple.builder().id(1L).name("").createTime(System.currentTimeMillis()).updateTime(System.currentTimeMillis()).build();
        appleService.updateByXmlWithTime(apple);
    }

    /**
     * 测试xml修改 -- 不带时间参数
     */
    @Test
    public void updateWithXmlWithoutTime() {
        Apple apple = Apple.builder().id(1L).name("").createTime(System.currentTimeMillis()).updateTime(System.currentTimeMillis()).build();
        appleService.updateByXmlWithoutTime(apple);
    }

}
