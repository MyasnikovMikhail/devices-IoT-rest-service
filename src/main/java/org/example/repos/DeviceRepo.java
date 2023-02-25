package org.example.repos;

import org.example.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<Device, Long> {
}
