package org.example.controller;

import org.example.model.Device;
import org.example.model.dto.DeviceDto;
import org.example.model.dto.DeviceReadDto;
import org.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Validated
@RestController
public class DeviceController {
    private final DeviceService deviceService;


    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping(value="/device")
    public String create(@RequestBody DeviceDto deviceDto){
        deviceService.create(deviceDto);
        return deviceDto.getSecretKey();
    }

    @GetMapping(value="/device")
    public Page<DeviceReadDto> readAllDevices(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(1000) Integer limit
    ) {
        return deviceService.readAllDevices(offset, limit);
    }
}
