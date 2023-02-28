package org.example.model.dto;


import java.time.LocalDateTime;

public class DeviceReadDto {
    private Long id;

    private String serialNumber;

    private String typeDevices;

    private String nameDevices;

    private LocalDateTime dataAdd;

    public DeviceReadDto() {
    }

    public String getTypeDevices() {
        return typeDevices;
    }

    public void setTypeDevices(String typeDevices) {
        this.typeDevices = typeDevices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNameDevices() {
        return nameDevices;
    }

    public void setNameDevices(String nameDevices) {
        this.nameDevices = nameDevices;
    }

    public LocalDateTime getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(LocalDateTime dataAdd) {
        this.dataAdd = dataAdd;
    }
}
