package com.lz.service;

import org.springframework.stereotype.Component;

/**
 * 降级回退逻辑需要定义一个类,实现FeignClient接口,实现接口中的方法
 * @author lihao
 * @date 2021-11-28 23:02
 */
@Component
public class ResumeFallBack implements ResumeServiceFeignClient {
    @Override
    public Integer findDefaultResumeState(Long userId) {
        return -1;
    }
}
