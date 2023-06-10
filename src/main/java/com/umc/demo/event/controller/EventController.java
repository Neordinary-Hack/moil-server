package com.umc.demo.event.controller;

import com.umc.demo.event.service.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {

        this.eventService = eventService;
    }
}
