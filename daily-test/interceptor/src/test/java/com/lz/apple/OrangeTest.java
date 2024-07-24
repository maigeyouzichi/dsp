package com.lz.Orange;

import com.lz.InterceptorApplication;
import com.lz.fruit.entity.Orange;
import com.lz.fruit.service.OrangeService;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试Orange实体
 * @author lihao on 2024/7/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InterceptorApplication.class)
public class OrangeTest {

    @Resource
    private OrangeService orangeService;

    /**
     * 测试lambda新增 -- 带时间参数
     */
    @Test
    public void addWithLambdaWithTime() {
        Orange orange = Orange.builder().name("one").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
        orangeService.addWithLambda(orange);
    }

    /**
     * 测试lambda新增 -- 不带时间参数
     */
    @Test
    public void addWithLambdaWithoutTime() {
        Orange orange = Orange.builder().name("one").build();
        orangeService.addWithLambda(orange);
    }

    /**
     * 测试xml新增 -- 带时间参数
     */
    @Test
    public void addWithXmlWithTime() {
        Orange orange = Orange.builder().name("one").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
        orangeService.addWithXmlWithTime(orange);
    }

    /**
     * 测试xml新增 -- 不带时间参数
     */
    @Test
    public void addWithXmlWithoutTime() {
        Orange orange = Orange.builder().name("one").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
        orangeService.addWithXmlWithoutTime(orange);
    }

    /**
     * 测试lambda 实体修改 -- 带时间参数
     */
    @Test
    public void updateWithLambdaAndEntityWithTime() {
        Orange orange = Orange.builder().id(1L).name("").updateTime(LocalDateTime.now()).build();
        orangeService.updateWithLambdaById(orange);
    }

    /**
     * 测试lambda 实体修改 -- 不带时间参数
     */
    @Test
    public void updateWithLambdaAndEntityWithoutTime() {
        Orange orange = Orange.builder().id(1L).name("").build();
        orangeService.updateWithLambdaById(orange);
    }

    /**
     * 测试lambda 修改 -- 带时间参数
     */
    @Test
    public void updateWithLambdaParamWithTime() {
        Orange orange = Orange.builder().id(1L).name("").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
        orangeService.updateWithLambdaByParam(orange);
    }

    /**
     * 测试lambda 修改 -- 不带时间参数
     */
    @Test
    public void updateWithLambdaParamWithoutTime() {
        Orange orange = Orange.builder().id(1L).name("").build();
        orangeService.updateWithLambdaByParam(orange);
    }

    /**
     * 测试xml修改 -- 带时间参数
     */
    @Test
    public void updateWithXmlWithTime() {
        Orange orange = Orange.builder().id(1L).name("").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
        orangeService.updateByXmlWithTime(orange);
    }

    /**
     * 测试xml修改 -- 不带时间参数
     */
    @Test
    public void updateWithXmlWithoutTime() {
        Orange orange = Orange.builder().id(1L).name("").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
        orangeService.updateByXmlWithoutTime(orange);
    }

}
