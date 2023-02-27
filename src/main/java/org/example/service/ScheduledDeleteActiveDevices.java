package org.example.service;

import org.example.repos.ActiveDevicesRepo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@EnableScheduling
@Component
public class ScheduledDeleteActiveDevices {
    private final ActiveDevicesRepo activeDevicesRepo;

    public ScheduledDeleteActiveDevices(ActiveDevicesRepo activeDevicesRepo) {
        this.activeDevicesRepo = activeDevicesRepo;
    }
    @Transactional
    public void scheduleFixedRateTask() {
        activeDevicesRepo.deleteAllByLastDateActiveBefore(LocalDateTime.now().minusMinutes(30));
    }
}
