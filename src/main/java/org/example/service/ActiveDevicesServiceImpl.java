package org.example.service;

import org.example.model.ActiveDevices;
import org.example.model.dto.ActiveDevicesDto;
import org.example.repos.ActiveDevicesRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActiveDevicesServiceImpl implements ActiveDevicesService{

    private final ActiveDevicesRepo activeDevicesRepo;

    public ActiveDevicesServiceImpl(ActiveDevicesRepo activeDevicesRepo) {
        this.activeDevicesRepo = activeDevicesRepo;
    }

    @Override
    @Transactional
    public List<ActiveDevices> readAll(ActiveDevicesDto activeDevicesDto) {
        return activeDevicesRepo.findAllByLastDateActiveBetween(LocalDateTime.now().minusMinutes(30), LocalDateTime.now());

    }
}
