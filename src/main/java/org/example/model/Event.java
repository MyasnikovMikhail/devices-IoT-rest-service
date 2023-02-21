package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="events")
public class Event {
    @Id
    @Column(name="id")
    @SequenceGenerator(name="event_seq", sequenceName="SEQ_EVENTS", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "event_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="device_id", nullable = false)
    private Device device;

    @Column(name="type_event")
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;

    @Column(name="payload")
    private Object payload;

    @Column(name="date_Created")
    private LocalDateTime dateCreated;

    @Column(name="active_devices")
    private Integer activeDevices;

    public Event() {
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

    public TypeEvent getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(TypeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getActiveDevices() {
        return activeDevices;
    }

    public void setActiveDevices(Integer activeDevices) {
        this.activeDevices = activeDevices;
    }
}
