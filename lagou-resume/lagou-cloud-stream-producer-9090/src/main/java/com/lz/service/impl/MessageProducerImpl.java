package com.lz.service.impl;

import com.lz.service.IMessageProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Source.class 就是对通道的定义,内置的通道封装
 * @author lihao
 * @date 2021-12-02 00:08
 */
@EnableBinding(Source.class)
public class MessageProducerImpl implements IMessageProducer {

    private final Source source;

    public MessageProducerImpl(Source source) {
        this.source = source;
    }

    @Override
    public void sendMessage(String content) {
        //向mq中发送消息,不是直接操作mq,应该操作spring-cloud-stream
        //使用通道向外发送消息,指的是source里面的output通道
        source.output().send(MessageBuilder.withPayload(content).build());
    }
}
