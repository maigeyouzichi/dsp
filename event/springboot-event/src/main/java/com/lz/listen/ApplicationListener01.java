package com.lz.listen;

import com.lz.event.LocalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lihao
 * @date 2022-05-15 00:47
 */
@Component
@Slf4j
public class ApplicationListener01 implements ApplicationListener<LocalEvent> {

    @Override
    public void onApplicationEvent(LocalEvent event) {
        log.info("Application01触发事件监听 ...");
        log.info("Application01监听消息内容: {}",event.getMessage());
    }
}
