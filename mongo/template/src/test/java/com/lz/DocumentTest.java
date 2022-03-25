package com.lz;

import com.lz.entity.User;
import com.lz.service.AggregateGroupService;
import com.lz.service.AggregatePipelineService;
import com.lz.service.InsertService;
import com.lz.service.QueryService;
import com.lz.service.RemoveService;
import com.lz.service.SaveService;
import com.lz.service.UpdateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 文档测试
 *
 * @author lihao
 * @date 2022-03-22 23:07
 */
@SpringBootTest(classes = TemplateApplication.class)
@RunWith(SpringRunner.class)
public class DocumentTest {

    @Autowired
    private InsertService insertService;
    @Autowired
    private SaveService saveService;
    @Autowired
    private UpdateService updateService;
    @Autowired
    private QueryService queryService;
    @Autowired
    private RemoveService removeService;
    @Autowired
    private AggregateGroupService aggregateGroupService;

    @Test
    public void tmp() {

    }

    @Test
    public void createOrSave() {
        //create -> 有重复会报错
        for (int i = 2; i <= 3; i++) {
            insertService.insert("zhangsan" + i, i);
        }
        //save -> 有重复会修改
//        for (int i = 1; i <=1000; i++) {
//            saveService.save(i+"","lisi"+i,i);
//        }
    }

    @Test
    public void update() {
        updateService.updateFirst();
    }

    @Test
    public void query() {
        //List<User> userList = queryService.findByCondition();
        List<User> userList = queryService.findByConditionAndSort();
        System.out.println(userList.size());
    }

    @Test
    public void remove() {
        removeService.remove();
    }

    /**
     * 文档聚合操作
     */
    @Test
    public void group() {
//        aggregateGroupService.aggregationGroupCount();
//        aggregateGroupService.aggregationGroupMax();
        aggregateGroupService.aggregationGroupPush();
    }


    @Autowired
    private AggregatePipelineService pipelineService;
    @Test
    public void pipeline() {
        pipelineService.aggregateGroupMatch();
    }
}
