package org.example.model.dto;

import org.example.model.Device;

import java.time.LocalDateTime;

public class ActiveDevicesDto {

    private Long id;

    private Long deviceId;

    private LocalDateTime firstDateActive;

    private LocalDateTime lastDateActive;

    public ActiveDevicesDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getFirstDateActive() {
        return firstDateActive;
    }

    public void setFirstDateActive(LocalDateTime firstDateActive) {
        this.firstDateActive = firstDateActive;
    }

    public LocalDateTime getLastDateActive() {
        return lastDateActive;
    }

    public void setLastDateActive(LocalDateTime lastDateActive) {
        this.lastDateActive = lastDateActive;
    }
}
