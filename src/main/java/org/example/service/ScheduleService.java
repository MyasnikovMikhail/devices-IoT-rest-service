package org.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScheduleService {

    private final ScheduledDeleteActiveDevices scheduledDeleteActiveDevices;

    public ScheduleService(ScheduledDeleteActiveDevices scheduledDeleteActiveDevices) {
        this.scheduledDeleteActiveDevices = scheduledDeleteActiveDevices;
    }


    @Scheduled(fixedRate = 60000, initialDelay = 60000)
    public void scheduleActiveDevices(){
        scheduledDeleteActiveDevices.scheduleFixedRateTask();
    }
}
