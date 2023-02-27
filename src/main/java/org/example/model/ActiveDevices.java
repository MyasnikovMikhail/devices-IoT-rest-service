package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="active_devices")
public class ActiveDevices {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "active_devices_Seq", sequenceName = "SEQ_ACTIVE_DEVICE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "active_devices_Seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="device_id", nullable = false)
    private Device device;

    @Column(name="first_date_active")
    private LocalDateTime firstDateActive;

    @Column(name="last_date_active")
    private LocalDateTime lastDateActive;

    public ActiveDevices() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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
