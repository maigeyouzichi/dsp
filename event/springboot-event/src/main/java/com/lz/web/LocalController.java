package com.lz.web;

import com.lz.event.LocalEvent;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao
 * @date 2022-05-14 23:46
 */
@RestController
public class LocalController {

    private final ApplicationEventPublisher publisher;

    public LocalController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @SneakyThrows
    @GetMapping("/event/publish")
    public String publish() {
        publisher.publishEvent(new LocalEvent("","Hello World"));
        TimeUnit.SECONDS.sleep(5);
        return "success";
    }
}
