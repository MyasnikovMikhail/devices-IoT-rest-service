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
}
