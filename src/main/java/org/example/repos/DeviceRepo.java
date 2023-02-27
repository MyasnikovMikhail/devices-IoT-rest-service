package org.example.repos;

import org.example.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Long> {
    Device findBySerialNumber(String serialNumber);
}
