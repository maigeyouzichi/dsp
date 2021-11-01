package com.lz;

import com.lz.service.HelloService;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

/**
 * @author lihao
 * @date 2021-11-01 23:01
 */
public class DubboSpiMain {

    public static void main(String[] args) {
        //1,获取扩展加载器
        ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);
        //2,遍历所有所支持的扩展点
        Set<String> extensions = extensionLoader.getSupportedExtensions();
        for (String extension : extensions) {
            System.out.println(extensionLoader.getExtension(extension).sayHello());
        }
    }
}
