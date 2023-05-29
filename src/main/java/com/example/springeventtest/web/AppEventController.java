package com.example.springeventtest.web;

import com.example.springeventtest.service.event.AppEventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AppEventController {

    private final AppEventService appEventService;

    @GetMapping("/event")
    public void call(){
        appEventService.call();
    }
}
