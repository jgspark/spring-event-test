package com.example.springeventtest.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
public class Mail {

    private final Long mailId;

    public void send() {
        log.info("mail 을 보낸다. mail id : {}", mailId);
    }
}
