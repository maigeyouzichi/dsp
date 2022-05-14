package com.lz.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author lihao
 * @date 2022-05-14 23:33
 */
@Getter
@Setter
public class LocalEvent extends ApplicationEvent {

    private String message;

    /**
     * Create a new {@code ApplicationEvent}.
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public LocalEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
