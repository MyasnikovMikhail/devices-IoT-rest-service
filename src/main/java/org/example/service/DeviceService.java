package org.example.service;

import org.example.model.dto.DeviceDto;

import java.security.NoSuchAlgorithmException;

public interface DeviceService {
    String create(DeviceDto deviceDto);
}
