package com.example.springeventtest.service.event;

import com.example.springeventtest.domain.event.AppEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppEventService {

    private final ApplicationEventPublisher publisher;

    public void call() {
        log.info("working to call back event");
        publisher.publishEvent(new AppEvent(this, 1L, 2L));
    }
}
