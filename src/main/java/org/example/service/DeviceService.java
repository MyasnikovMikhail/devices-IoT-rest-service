package org.example.service;

import org.example.model.Device;
import org.example.model.dto.DeviceDto;

public interface DeviceService {
    String create(DeviceDto deviceDto);
    Device read(String serialNumber);
}
