package org.example.controller;

import org.example.model.dto.DeviceDto;
import org.example.model.dto.EventDto;
import org.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(value="/event")
    public void create(@RequestBody EventDto eventDto){
        eventService.create(eventDto);
    }
}
