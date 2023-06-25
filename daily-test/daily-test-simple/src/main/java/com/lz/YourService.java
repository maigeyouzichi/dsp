package com.lz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 在你的控制器或服务类中
public class YourService {

    public boolean isValidParameter(String parameter) {
        // 定义正则表达式
        String regex = "^[a-zA-Z][a-zA-Z0-9]*$";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(parameter);

        // 进行匹配
        return matcher.matches();
    }

    // 使用示例
    public void exampleUsage() {
        String parameter1 = "abc123"; // 合法的参数
        String parameter2 = "123abc"; // 非法的参数
        String parameter3 = "Abc123"; // 合法的参数

        System.out.println(isValidParameter(parameter1)); // 输出: true
        System.out.println(isValidParameter(parameter2)); // 输出: false
        System.out.println(isValidParameter(parameter3)); // 输出: true
    }
}
