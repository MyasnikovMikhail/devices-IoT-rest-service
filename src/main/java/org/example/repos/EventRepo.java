package org.example.repos;

import org.example.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    Page<Event> findAllByDeviceSerialNumber(String serialNumber, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select devices.type_Device, count(device) from events, devices group by devices.typeDevice where dateCreated > dateStart and dateCreated < dateStop");
    List<Event> advancedSearch(@Param("postDateStart") LocalDateTime dateStart, @Param("postDateStop") LocalDateTime dateStop);
}
