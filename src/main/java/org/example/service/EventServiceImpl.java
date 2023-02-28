package org.example.service;

import org.example.exception.NoSuchObjectException;
import org.example.model.ActiveDevices;
import org.example.model.Device;
import org.example.model.Event;
import org.example.model.dto.ActiveDevicesDto;
import org.example.model.dto.EventDto;
import org.example.model.dto.StatsDto;
import org.example.repos.ActiveDevicesRepo;
import org.example.repos.DeviceRepo;
import org.example.repos.EventRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
            ActiveDevicesDto activeDevicesDto = new ActiveDevicesDto();
            if (activeDevicesRepo.findActiveDevicesByDeviceId(eventDto.getDeviceId()).isPresent()) {
                activeDevicesDto = convertToActiveDevices(activeDevicesRepo.findActiveDevicesByDeviceId(eventDto.getDeviceId()).get());
            } else {
                activeDevicesDto.setFirstDateActive(LocalDateTime.now());
                activeDevicesDto.setId(eventDto.getDeviceId());
            }
            activeDevicesDto.setLastDateActive(LocalDateTime.now());
            activeDevicesRepo.save(convertToActiveDevicesDTO(activeDevicesDto));
            eventRepo.save(convertToEventDTO(eventDto));

        } else {
            throw new NoSuchObjectException("There is no device with ID = " + eventDto.getDeviceId() + " in Database or incorrect SecretKey");
        }

    }

    @Override
    public Page<EventDto> readBySerialNumber(String serialNumber, Pageable pageWithDevices) {
        Page<Event> eventPage = eventRepo.findAllByDeviceSerialNumber(serialNumber, pageWithDevices);
        return eventPage.map(this::convertToEvent);
    }

    @Override
    @Transactional
    public List<StatsDto> collectStatisticsEvents(LocalDateTime dateStart, LocalDateTime dataEnd) {
        return eventRepo.collectStatistics(dateStart, dataEnd);
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

    private EventDto convertToEvent(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setTypeEvent(event.getTypeEvent());
        eventDto.setPayload(event.getPayload());
        eventDto.setDateCreated(event.getDateCreated());
        eventDto.setDeviceId(eventDto.getDeviceId());
        return eventDto;
    }

    private ActiveDevices convertToActiveDevicesDTO(ActiveDevicesDto activeDevicesDto){
        ActiveDevices activeDevices = new ActiveDevices();
        activeDevices.setId(activeDevicesDto.getId());
        activeDevices.setDevice(deviceRepo.findById(activeDevicesDto.getId()).get());
        activeDevices.setFirstDateActive(activeDevicesDto.getFirstDateActive());
        activeDevices.setLastDateActive(activeDevicesDto.getLastDateActive());
        return activeDevices;
    }

    private ActiveDevicesDto convertToActiveDevices(ActiveDevices activeDevices){
        ActiveDevicesDto activeDevicesDto = new ActiveDevicesDto();
        activeDevicesDto.setId(activeDevices.getId());
        activeDevicesDto.setDeviceId(activeDevices.getId());
        activeDevicesDto.setFirstDateActive(activeDevices.getFirstDateActive());
        activeDevicesDto.setLastDateActive(activeDevices.getLastDateActive());
        return activeDevicesDto;
    }

}
