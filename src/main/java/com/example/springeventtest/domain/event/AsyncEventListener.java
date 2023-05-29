package com.example.springeventtest.domain.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncEventListener {

    @Async
    @EventListener(value = AppEvent2.class)
    public void sendEvent(AppEvent2 appEvent2) {
        Push push = new Push(appEvent2.getPushId());
        Mail mail = new Mail(appEvent2.getMailId());
        push.send();
        mail.send();
    }
}
