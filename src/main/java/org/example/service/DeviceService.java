package org.example.service;

import org.example.model.Device;
import org.example.model.dto.DeviceDto;
import org.example.model.dto.DeviceReadDto;
import org.springframework.data.domain.Page;

public interface DeviceService {
    String create(DeviceDto deviceDto);
    DeviceDto read(String serialNumber);
    Page<DeviceReadDto> readAllDevices(Integer offset, Integer limit);
}
