package com.lz;

import com.lz.cglib.CglibProxy;
import com.lz.jdk.reflect.JDKProxy;
import com.lz.service.DogService;
import com.lz.service.IUserService;
import com.lz.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicProxyApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 测试JDK动态代理
     */
    @Test
    public void test_proxy_jdk() {
        //代理任何传入的对象,防止写死
        IUserService proxy = JDKProxy.getProxy(new UserService());
        String userName = proxy.queryUserNameById("10001");
        System.out.println(userName);
    }

    /**
     * 测试CGLIB动态代理
     */
    @Test
    public void test_proxy_cglib() {
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService = (UserService) cglibProxy.newInstall(new UserService());
        String userName = userService.queryUserNameById("10001");
        System.out.println(userName);
    }

    @Test
    public void test_proxy_cglib_dog() {
        CglibProxy cglibProxy = new CglibProxy();
        DogService dogService = (DogService) cglibProxy.newInstall(new DogService());
        dogService.run();
    }

}
