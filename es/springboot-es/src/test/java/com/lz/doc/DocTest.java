package com.lz.doc;

import com.lz.SpringbootEsApplication;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @author lihao
 * @date 2022-04-10 15:50
 */
@SpringBootTest(classes = SpringbootEsApplication.class)
@RunWith(SpringRunner.class)
public class DocTest {

    @Resource
    private RestHighLevelClient restClient;

    @Test
    public void testBefore() {
        System.out.println(restClient);
    }

    //查询文档
    @Test
    public void testGetDoc() throws IOException {
        //查询请求对象
        GetRequest getRequest = new GetRequest("lagou-company-index", "2");
        GetResponse getResponse = restClient.get(getRequest, RequestOptions.DEFAULT);
        //得到文档的内容
        Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        System.out.println(sourceAsMap);
    }
}
