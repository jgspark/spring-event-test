package com.example.springeventtest.domain.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AppEvent2 extends ApplicationEvent {

    private final Long mailId;

    private final Long pushId;

    public AppEvent2(Object source, Long mailId, Long pushId) {
        super(source);
        this.mailId = mailId;
        this.pushId = pushId;
    }
}
