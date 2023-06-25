package com.lz.controller;

import com.lz.anno.UserEventRecord;
import com.lz.bizEnum.UserEventEnum;
import com.lz.controller.req.LoginReq;
import com.lz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao on 2023/4/15
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @UserEventRecord(event = UserEventEnum.LOGIN)
    @PostMapping("/login")
    public String login(@RequestBody LoginReq req) {
//        testService.login(req, new LoginReq2(req.getName(),req.getAge()));
        testService.login2();
//        testService.login3(req.getName());
//        testService.login4(null,req.getAge());
//        testService.login4(null,null);
//        testService.login5(req.getName(),req);
        int i = 1/0;
        return "success";
    }
}
