package org.example.controller;

import org.example.model.Device;
import org.example.model.dto.DeviceDto;
import org.example.service.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class DeviceController {
    private final DeviceService deviceService;


    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping(value="/device")
    public void create(@RequestBody DeviceDto deviceDto){
        deviceService.create(deviceDto);
    }
}
