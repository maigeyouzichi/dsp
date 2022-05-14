package com.lz.listen;

import com.lz.event.LocalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author lihao
 * @date 2022-05-14 23:38
 */
@Component
@Slf4j
public class LocalListener {

    @EventListener
    public void messageHandler(LocalEvent event) {
        log.info("触发事件监听 ...");
        log.info("监听消息内容: {}",event.getMessage());
    }
}
