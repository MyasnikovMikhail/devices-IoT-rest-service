package org.example.service;

import org.example.exception.NoSuchObjectException;
import org.example.model.Device;
import org.example.model.Event;
import org.example.model.dto.EventDto;
import org.example.repos.DeviceRepo;
import org.example.repos.EventRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepo eventRepo;
    private final DeviceRepo deviceRepo;

    private final PasswordEncoder passwordEncoder;

    public EventServiceImpl(EventRepo eventRepo, DeviceRepo deviceRepo, PasswordEncoder passwordEncoder) {
        this.eventRepo = eventRepo;
        this.deviceRepo = deviceRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void create(EventDto eventDto) {
        if (deviceRepo.findById(eventDto.getDeviceId()).isPresent() && passwordEncoder.matches(eventDto.getSecretKey(), deviceRepo.findById(eventDto.getDeviceId()).get().getSecretKey())) {
            eventRepo.save(convertToEventDTO(eventDto));
        } else {
            throw new NoSuchObjectException("There is no device with ID = " + eventDto.getDeviceId() + " in Database");
        }
    }

    private Event convertToEventDTO(EventDto eventDto){
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setTypeEvent(eventDto.getTypeEvent());
        event.setPayload(eventDto.getPayload());
        event.setDateCreated(LocalDateTime.now());
        event.setDevice(deviceRepo.findById(eventDto.getDeviceId()).get());
        return event;
    }
}
