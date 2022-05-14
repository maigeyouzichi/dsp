package com.lz.listen;

import com.lz.event.LocalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 另外一种监听的方式,同样支持多个监听器监听同样的消息
 * @author lihao
 * @date 2022-05-15 00:50
 */
@Component
@Slf4j
public class ApplicationListener02 implements ApplicationListener<LocalEvent> {
    @Override
    public void onApplicationEvent(LocalEvent event) {
        log.info("ApplicationListener02触发事件监听 ...");
        log.info("ApplicationListener02监听消息内容: {}",event.getMessage());
    }
}
