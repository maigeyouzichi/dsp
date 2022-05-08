package com.lz;

import com.lz.service.CreateCollectionService;
import com.lz.service.QueryCollectionService;
import com.lz.service.RemoveCollectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试集合
 * @author lihao
 * @date 2022-03-22 22:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TemplateApplication.class)
public class CollectionTest {
    @Autowired
    private CreateCollectionService createService;
    @Autowired
    private QueryCollectionService queryService;
    @Autowired
    private RemoveCollectionService removeService;

    /**
     * 创建集合
     */
    @Test
    public void createCollect() {
        //重复创建会抛出异常
        //Object res = createService.createCollection("user1");
        //System.out.println(res);
        createService.createCollectionFixedSize("user2",1024,5);
        createService.createCollectionValidation("user3",20);
    }

    /**
     * 查询集合
     */
    @Test
    public void queryCollection() {
        boolean exit = queryService.collectionExists("user");
        System.out.println(exit);
        Object names = queryService.getCollectionNames();
        System.out.println(names);
    }

    @Test
    public void removeCollection() {
        String res = removeService.dropCollection("user3");
        System.out.println(res);
    }
}
