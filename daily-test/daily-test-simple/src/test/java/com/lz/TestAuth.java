package com.lz;

import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lihao on 2023/2/5
 */
@SpringBootTest
public class TestAuth {

    @Test
    void test001() {
        String auth = getBasicAuthenticationHeader("750cfc62-8f06-43e1-b8cb-7ed270dc2278", "cQgtg4U3X3pxmOuhUG5pbVaDbCGX40aZBJoHXZzk");
        System.out.println(auth);
    }

    /**
     * 生成 Basic Authorization
     * @param username
     * @param password
     * @return
     */
    private String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
