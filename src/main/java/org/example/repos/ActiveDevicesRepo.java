package org.example.repos;

import org.example.model.ActiveDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActiveDevicesRepo extends JpaRepository<ActiveDevices, Long> {
    Optional<ActiveDevices> findActiveDevicesByDeviceId (Long id);

    List<ActiveDevices> findAllByLastDateActiveBetween(LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime);

    void deleteAllByLastDateActiveBefore(LocalDateTime dataTime);
}
