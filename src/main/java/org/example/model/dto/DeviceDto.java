package org.example.model.dto;


public class DeviceDto {
    private Long id;

    private int serialNumber;

    private int nameDevices;

    private int dataAdd;

    private String secretKey;

    public DeviceDto() {
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

    public int getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(int dataAdd) {
        this.dataAdd = dataAdd;
    }
}
