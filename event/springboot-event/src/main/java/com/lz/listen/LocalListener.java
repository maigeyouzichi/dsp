package com.lz.listen;

import com.lz.event.LocalEvent;
import com.lz.event.OtherEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
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
        log.info("Local触发事件监听 ...");
        log.info("Local监听消息内容: {}",event.getMessage());
    }

    /**
     *支持多个监听器同时工作,监听同一个事件,并分开处理.
     * @param event
     */
    @EventListener
    public void messageHandler02(LocalEvent event) {
        log.info("Local02触发事件监听 ...");
        log.info("Local02监听消息内容: {}",event.getMessage());
    }



    /**
     * 根据事件对象进行监听,不同的事件监听之间是隔离的
     */
    @EventListener
    @Async
    public void messageHandler(OtherEvent event) {
        log.info("Other触发事件监听 ...");
        log.info("Other监听消息内容: {}",event.getMessage());
        throw new RuntimeException("主动异常");
    }
}
