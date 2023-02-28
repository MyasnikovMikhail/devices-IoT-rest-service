package org.example.model.dto;

public class StatsDto {
    private String typeDevices;

    private Long countEvent;

    public StatsDto() {
    }

    public String getTypeDevices() {
        return typeDevices;
    }

    public void setTypeDevices(String typeDevices) {
        this.typeDevices = typeDevices;
    }

    public Long getCountEvent() {
        return countEvent;
    }

    public void setCountEvent(Long countEvent) {
        this.countEvent = countEvent;
    }
}
