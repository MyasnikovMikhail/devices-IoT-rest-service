package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="devices")
public class Device {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deviceIdSeq")
    @SequenceGenerator(name = "deviceIdSeq", sequenceName = "SEQ_SERVICE", allocationSize = 1)
    private Long id;

    @Column(name="serial_number", unique = true)
    private String serialNumber;

    @Column(name="name_devices")
    private String nameDevices;

    @Column(name="type_devices")
    private String typeDevices;

    @Column(name="secret_key")
    private String secretKey;

    @Column(name="data_added_in_system")
    private LocalDateTime dataAdd;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private Set<Event> event;

    public Device() {
    }

    public String getTypeDevices() {
        return typeDevices;
    }

    public void setTypeDevices(String typeDevices) {
        this.typeDevices = typeDevices;
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

    public Set<Event> getEvent() {
        return event;
    }

    public void setEvent(Set<Event> event) {
        this.event = event;
    }
}
