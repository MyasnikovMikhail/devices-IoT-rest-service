package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name="events")
public class Event {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "eventIdSeq")
    @SequenceGenerator(name = "eventIdSeq", sequenceName = "SEQ_SERVICE", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="device_id", nullable = false)
    private Device device;

    @Column(name="type_event")
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;


    @Column(name="payload")
    @Convert(converter = PayloadConverter.class)
    private Map<String,Object> payload;

    @Column(name="date_Created")
    private LocalDateTime dateCreated;

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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
