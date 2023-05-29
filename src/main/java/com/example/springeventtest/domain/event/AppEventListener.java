package com.example.springeventtest.domain.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppEventListener implements ApplicationListener<AppEvent> {

    @Override
    public void onApplicationEvent(AppEvent event) {

        Push push = new Push(event.getPushId());

        Mail mail = new Mail(event.getMailId());

        push.send();

        mail.send();
    }
}
