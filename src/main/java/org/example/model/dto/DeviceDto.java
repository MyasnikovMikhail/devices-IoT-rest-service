package org.example.model.dto;


import org.example.model.TypeDevices;

public class DeviceDto {
    private Long id;

    private String serialNumber;

    private String typeDevices;

    private String nameDevices;


    private String secretKey;

    public DeviceDto() {
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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}
