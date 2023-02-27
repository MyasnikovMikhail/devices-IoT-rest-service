package org.example.service;

import org.example.model.ActiveDevices;
import org.example.model.dto.ActiveDevicesDto;
import org.example.model.dto.DeviceDto;

import java.util.List;

public interface ActiveDevicesService {
    List<ActiveDevices> readAll(ActiveDevicesDto activeDevicesDto);
}
