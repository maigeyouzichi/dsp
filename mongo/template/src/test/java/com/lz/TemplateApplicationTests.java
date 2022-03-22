package com.lz;

import com.lz.entity.Mongo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TemplateApplication.class)
class TemplateApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        List<Mongo> mongos = mongoTemplate.find(new Query(), Mongo.class,"lihao_child1");
        for (Mongo mongo : mongos) {
            System.out.println(mongo);
        }
    }

}
