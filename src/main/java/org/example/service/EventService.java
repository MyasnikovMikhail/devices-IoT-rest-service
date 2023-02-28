package org.example.service;

import org.example.model.Event;
import org.example.model.dto.EventDto;
import org.example.model.dto.StatsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    void create(EventDto eventDto);

    Page<EventDto> readBySerialNumber(String serialNumber, Pageable pageWithDevices);

    List<StatsDto> collectStatisticsEvents(LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime);
}
