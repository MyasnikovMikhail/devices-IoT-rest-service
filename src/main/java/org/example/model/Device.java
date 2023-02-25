package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="devices")
public class Device {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "device_seq", sequenceName = "SEQ_DEVICE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "device_seq")
    private Long id;

    @Column(name="serial_number", unique = true)
    private int serialNumber;

    @Column(name="name_devices")
    private int nameDevices;

    @Column(name="secret_key")
    private String secretKey;

    @Column(name="data_added_in_system")
    private LocalDateTime dataAdd;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private Set<Event> event;

    public Device() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
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

    public LocalDateTime getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(LocalDateTime dataAdd) {
        this.dataAdd = dataAdd;
    }

    public Set<Event> getEvent() {
        return event;
    }

    public void setEvent(Set<Event> event) {
        this.event = event;
    }
}
