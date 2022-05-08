package com.lz;

import com.lz.service.ViewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试视图
 * @author lihao
 * @date 2022-03-22 23:00
 */
@SpringBootTest(classes = TemplateApplication.class)
@RunWith(SpringRunner.class)
public class ViewTest {

    @Autowired
    private ViewService viewService;

    @Test
    public void createView() {
        String res = viewService.createView();
        System.out.println(res);

        String res2 = viewService.dropView();
        System.out.println(res2);
    }
}
