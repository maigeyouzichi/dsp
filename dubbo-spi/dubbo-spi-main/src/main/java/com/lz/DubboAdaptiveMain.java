package com.lz;

import com.lz.service.HelloService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author lihao
 * @date 2021-11-01 23:18
 */
public class DubboAdaptiveMain {

    public static void main(String[] args) {
        URL url = URL.valueOf("http://localhost?hello.service=human");
        //如果url不指定,接口处也可以指定默认的实现类(url优先级更高一些)
        //URL url = URL.valueOf("http://localhost");
        ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);
        final HelloService helloService = extensionLoader.getAdaptiveExtension();
        System.out.println(helloService.sayHello(url));
    }
}
