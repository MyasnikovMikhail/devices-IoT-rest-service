package org.example.repos;

import org.example.model.Event;
import org.example.model.dto.StatsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    Page<Event> findAllByDeviceSerialNumber(String serialNumber, Pageable pageable);

    @Query(value ="select devices.type_devices as typeDevices, count(events.device_id) as devicesCount \n" +
            "from events join devices\n" +
            "on events.device_id = devices.id\n" +
            "where events.date_created > dateStart and events.date_created < dateStop\n" +
            "group by devices.type_devices", nativeQuery = true)
    List<StatsDto> collectStatistics(@Param("dateStart") LocalDateTime dateStart, @Param("dateStop") LocalDateTime dateStop);
}
