package org.example.model.dto;

import java.time.LocalDateTime;


public class DevicesDto {
    private Long id;

    private int serialNumber;

    private int typeDevices;

    private int nameDevices;

    private String secretKey;

    private LocalDateTime dataAdd;

    public DevicesDto() {
    }

    public int getTypeDevices() {
        return typeDevices;
    }

    public void setTypeDevices(int typeDevices) {
        this.typeDevices = typeDevices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getNameDevices() {
        return nameDevices;
    }

    public void setNameDevices(int nameDevices) {
        this.nameDevices = nameDevices;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDateTime getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(LocalDateTime dataAdd) {
        this.dataAdd = dataAdd;
    }
}
