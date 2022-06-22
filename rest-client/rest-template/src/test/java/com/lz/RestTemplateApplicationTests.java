package com.lz;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

@SpringBootTest(classes = RestTemplateApplication.class)
@RunWith(SpringRunner.class)
class RestTemplateApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        System.out.println("地址: " + restTemplate);
    }

    @Test
    void test001() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-org-id", "1");
        httpHeaders.add("x-user-id", "2");
        httpHeaders.add("X-User-Name", "H");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://172.16.9.144:8080/v1/project";
        HttpEntity<String> httpEntity = new HttpEntity<>("{}", httpHeaders);
        Object res = "";
        try {
            res = restTemplate.postForEntity(url, httpEntity, String.class);//Read timed out
        } catch (Exception e) {
            System.out.println("e.message:" + e.getMessage());
            System.out.println("是否包含要求字段: " + e.getMessage().contains("项目号不能为空"));
            System.out.println("e.cause:" + e.getCause());
        }
    }

    @Test
    public void test002() {
        String str = "[{\"message\":\"项目号重复\",\"description\":\"项目号重复\",\"sta";
        String str2 = "项目号重复";
        String target = "项目号重复";
        System.out.println(str.contains(target));
        System.out.println(str2.contains(target));
    }

}
