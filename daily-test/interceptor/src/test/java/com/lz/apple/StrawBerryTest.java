package com.lz.apple;

import com.lz.InterceptorApplication;
import com.lz.fruit.entity.Strawberry;
import com.lz.fruit.service.StrawberryService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试strawBerry实体
 * @author lihao on 2024/7/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InterceptorApplication.class)
public class StrawBerryTest {

    @Resource
    private StrawberryService strawberryService;

    /**
     * 测试lambda新增 -- 带时间参数
     */
    @Test
    public void addWithLambdaWithTime() {
        Strawberry strawberry = Strawberry.builder().name("one").createTime(Timestamp.valueOf(LocalDateTime.now())).updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        strawberryService.addWithLambda(strawberry);
    }

    /**
     * 测试lambda新增 -- 不带时间参数
     */
    @Test
    public void addWithLambdaWithoutTime() {
        Strawberry strawberry = Strawberry.builder().name("one").build();
        strawberryService.addWithLambda(strawberry);
    }

    /**
     * 测试xml新增 -- 带时间参数
     */
    @Test
    public void addWithXmlWithTime() {
        Strawberry strawberry = Strawberry.builder().name("one").createTime(Timestamp.valueOf(LocalDateTime.now())).updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        strawberryService.addWithXmlWithTime(strawberry);
    }

    /**
     * 测试xml新增 -- 不带时间参数
     */
    @Test
    public void addWithXmlWithoutTime() {
        Strawberry strawberry = Strawberry.builder().name("one").createTime(Timestamp.valueOf(LocalDateTime.now())).updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        strawberryService.addWithXmlWithoutTime(strawberry);
    }

    /**
     * 测试lambda 实体修改 -- 带时间参数
     */
    @Test
    public void updateWithLambdaAndEntityWithTime() {
        Strawberry strawberry = Strawberry.builder().id(1L).name("").updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        strawberryService.updateWithLambdaById(strawberry);
    }

    /**
     * 测试lambda 实体修改 -- 不带时间参数
     */
    @Test
    public void updateWithLambdaAndEntityWithoutTime() {
        Strawberry strawberry = Strawberry.builder().id(1L).name("").build();
        strawberryService.updateWithLambdaById(strawberry);
    }

    /**
     * 测试lambda 修改 -- 带时间参数
     */
    @Test
    public void updateWithLambdaParamWithTime() {
        Strawberry strawberry = Strawberry.builder().id(1L).name("").createTime(Timestamp.valueOf(LocalDateTime.now())).updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        strawberryService.updateWithLambdaByParam(strawberry);
    }

    /**
     * 测试lambda 修改 -- 不带时间参数
     */
    @Test
    public void updateWithLambdaParamWithoutTime() {
        Strawberry strawberry = Strawberry.builder().id(1L).name("").build();
        strawberryService.updateWithLambdaByParam(strawberry);
    }

    /**
     * 测试xml修改 -- 带时间参数
     */
    @Test
    public void updateWithXmlWithTime() {
        Strawberry strawberry = Strawberry.builder().id(1L).name("").createTime(Timestamp.valueOf(LocalDateTime.now())).updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        strawberryService.updateByXmlWithTime(strawberry);
    }

    /**
     * 测试xml修改 -- 不带时间参数
     */
    @Test
    public void updateWithXmlWithoutTime() {
        Strawberry strawberry = Strawberry.builder().id(1L).name("").createTime(Timestamp.valueOf(LocalDateTime.now())).updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        strawberryService.updateByXmlWithoutTime(strawberry);
    }

}
