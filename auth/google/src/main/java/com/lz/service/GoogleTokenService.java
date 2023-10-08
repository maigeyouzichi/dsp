package com.lz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lihao on 2023/10/8
 */
@Service
public class GoogleTokenService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String GOOGLE_TOKEN_VERIFY_URL = "https://oauth2.googleapis.com/tokeninfo?id_token=";


}
