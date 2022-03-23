package com.lz;

import com.alibaba.fastjson.JSON;
import com.lz.service.RunCommandService;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lihao
 * @date 2022-03-23 15:43
 */
@SpringBootTest(classes = TemplateApplication.class)
@RunWith(SpringRunner.class)
public class RunCommandTest {

    @Autowired
    private RunCommandService runCommandService;

    @Test
    public void runCommand() {
        Document document = runCommandService.runCommand();
        System.out.println(JSON.toJSONString(document));
    }
}
