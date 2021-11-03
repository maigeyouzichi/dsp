package com.lz;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.lz.entity.Cat;
import com.lz.entity.Dog;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DailyTestSimpleApplication.class)
class DailyTestSimpleApplicationTests {

    @Autowired
    private JSONConfig jsonConfig;

    @Test
    void contextLoads() {
        //@JSONField(format = "yyyy-MM-dd HH:mm:ss")
        Date date = new Date();
        Dog dog = new Dog();
        dog.setName(null);
        dog.setBirthday(date);
        Cat cat = new Cat();
        cat.setDog(dog);
        cat.setName(null);
        System.out.println(JSONUtil.toJsonStr(JSONUtil.wrap(cat, jsonConfig)));
    }

}
