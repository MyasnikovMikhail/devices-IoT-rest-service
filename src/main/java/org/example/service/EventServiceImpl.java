package org.example.service;

import org.example.exception.NoSuchObjectException;
import org.example.model.ActiveDevices;
import org.example.model.Event;
import org.example.model.dto.ActiveDevicesDto;
import org.example.model.dto.EventDto;
import org.example.repos.ActiveDevicesRepo;
import org.example.repos.DeviceRepo;
import org.example.repos.EventRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepo eventRepo;
    private final DeviceRepo deviceRepo;

    private final ActiveDevicesRepo activeDevicesRepo;

    private final PasswordEncoder passwordEncoder;

    public EventServiceImpl(EventRepo eventRepo, DeviceRepo deviceRepo, ActiveDevicesRepo activeDevicesRepo, PasswordEncoder passwordEncoder) {
        this.eventRepo = eventRepo;
        this.deviceRepo = deviceRepo;
        this.activeDevicesRepo = activeDevicesRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void create(EventDto eventDto) {
        if (deviceRepo.findById(eventDto.getDeviceId()).isPresent() && passwordEncoder.matches(eventDto.getSecretKey(), deviceRepo.findById(eventDto.getDeviceId()).get().getSecretKey())) {
            eventRepo.save(convertToEventDTO(eventDto));
            ActiveDevicesDto activeDevicesDto = new ActiveDevicesDto();
            activeDevicesDto.setFirstDateActive(LocalDateTime.now());
            if (activeDevicesRepo.findById(eventDto.getDeviceId()).isPresent()) {
                ActiveDevices activeDevices = activeDevicesRepo.findActiveDevicesByDevice(eventDto.getDeviceId()).get();
                activeDevices.setLastDateActive(LocalDateTime.now());
                activeDevicesRepo.save(activeDevices);
            } else {
                activeDevicesDto.setLastDateActive(LocalDateTime.now());
                activeDevicesDto.setDeviceId(eventDto.getDeviceId());
                activeDevicesRepo.save(convertToActiveDevicesDTO(activeDevicesDto));
            }
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

    private ActiveDevices convertToActiveDevicesDTO(ActiveDevicesDto activeDevicesDto){
        ActiveDevices activeDevices = new ActiveDevices();
        activeDevices.setDevice(deviceRepo.findById(activeDevicesDto.getId()).get());
        activeDevices.setFirstDateActive(activeDevicesDto.getFirstDateActive());
        activeDevices.setLastDateActive(activeDevicesDto.getLastDateActive());
        return activeDevices;
    }
}
