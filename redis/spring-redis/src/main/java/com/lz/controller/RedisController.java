package com.lz.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao
 * @date 2022-01-11 20:56
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    private final StringRedisTemplate redisTemplate;

    public RedisController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/put")
    public String put(@RequestParam(required = true) String key, @RequestParam(required = true) String value) {
        //设置过期时间为20秒
        redisTemplate.opsForValue().set(key, value, 20, TimeUnit.SECONDS);
        return "Success";
    }

    @GetMapping("/get")
    public String get(@RequestParam(required = true) String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
