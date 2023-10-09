package com.lz.service;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.github.scribejava.apis.TwitterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_KEY = "C9R2Mqv5Ili0gRXo729lLyaLb";
    private static final String API_SECRET = "17TwbteVNyWz8zbBJ8V74l1fuGnBTVHFXCXxRfCa9gfJUHpfqg";
    private static final String TOKEN = "1519620147832492032-9hQtKxyFn74TDJVCpRdrr65f6QuRbP";
    private static final String TOKEN_SECRET = "dmdzmAQno1t61UNXmlC1IIcaOwcTDWS18lp7xQc0Wn7DS";
    private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";

    public void verifyCredentials() {
        try {
            // 构建OAuth服务
            OAuth10aService service = new ServiceBuilder(API_KEY)
                    .apiSecret(API_SECRET)
                    .build(TwitterApi.instance());

            // 构建Access Token
            OAuth1AccessToken accessToken = new OAuth1AccessToken(TOKEN, TOKEN_SECRET);

            // 创建一个请求并使用Access Token对其进行签名
            OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
            service.signRequest(accessToken, request);

            // 使用Spring的RestTemplate发送请求
            String response = restTemplate.getForObject(request.getCompleteUrl(), String.class);

            System.out.println("Twitter Response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
