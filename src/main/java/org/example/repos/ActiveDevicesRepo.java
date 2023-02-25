package org.example.repos;

import org.example.model.ActiveDevices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveDevicesRepo extends JpaRepository<ActiveDevices, Long> {
}
