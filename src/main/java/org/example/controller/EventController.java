package org.example.controller;

import org.example.model.Device;
import org.example.model.Event;
import org.example.model.dto.EventDto;
import org.example.model.dto.StatsDto;
import org.example.repos.EventRepo;
import org.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping(value="/eventSN")
    public Page<EventDto> read(
            @RequestParam(value = "serialNumber") String  serialNumber,
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(1000) Integer limit
    ) {
        Pageable pageWithDevices = PageRequest.of(offset, limit);
        return eventService.readBySerialNumber(serialNumber,pageWithDevices);
    }

    @GetMapping(value="/statistics")
    public List<StatsDto> collectStatisticsEvents(
            @RequestParam(value = "dateStart") LocalDateTime dateStart,
            @RequestParam(value = "dataEnd") LocalDateTime dataEnd
    ) {
        return eventService.collectStatisticsEvents(dateStart, dataEnd);
    }
}
