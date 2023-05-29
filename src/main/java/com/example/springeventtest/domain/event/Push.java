package com.example.springeventtest.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
public class Push {

    private final Long pushId;

    public void send() {
        log.info("push 를 보낸다. push id : {}", pushId);
    }
}
