package com.lz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
@Slf4j
public class MessageConsumerService {

    @StreamListener(Sink.INPUT)
    public void receiveMessages(Message<String> message) {
        log.info("=========接收到的消息：{}", message.getPayload());
    }
}