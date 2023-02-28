package org.example.model.dto;

import org.example.model.TypeDevices;

public class StatsDto {
    private TypeDevices typeDevices;

    private Long countEvent;

    public StatsDto() {
    }

    public TypeDevices getTypeDevices() {
        return typeDevices;
    }

    public void setTypeDevices(TypeDevices typeDevices) {
        this.typeDevices = typeDevices;
    }

    public Long getCountEvent() {
        return countEvent;
    }

    public void setCountEvent(Long countEvent) {
        this.countEvent = countEvent;
    }
}
