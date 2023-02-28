package org.example.service;

import org.example.model.Device;
import org.example.model.dto.DeviceDto;
import org.example.model.dto.DeviceReadDto;
import org.example.repos.DeviceRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class DeviceServiceImpl implements DeviceService{

    private final DeviceRepo deviceRepo;


    private final PasswordEncoder passwordEncoder;

    public DeviceServiceImpl(DeviceRepo deviceRepo, PasswordEncoder passwordEncoder) {
        this.deviceRepo = deviceRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public String create(DeviceDto deviceDto){
            deviceRepo.save(convertToDeviceDTO(deviceDto));
        return deviceDto.getSecretKey();
    }

    @Override
    public DeviceDto read(String serialNumber) {
        return deviceRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public Page<DeviceReadDto> readAllDevices(Integer offset, Integer limit) {
        Page<Device> devicePage =  deviceRepo.findAll(PageRequest.of(offset, limit));
        return devicePage.map(this::convertToDevice);
    }

    private Device convertToDeviceDTO(DeviceDto deviceDto){
        Device device = new Device();
        device.setId(deviceDto.getId());
        device.setSerialNumber(deviceDto.getSerialNumber());
        device.setNameDevices(deviceDto.getNameDevices());
        device.setTypeDevices(deviceDto.getTypeDevices());
        deviceDto.setSecretKey(generateRandomPassword());
        device.setSecretKey(passwordEncoder.encode(deviceDto.getSecretKey()));
        device.setDataAdd(LocalDateTime.now());
        return device;
    }

    private DeviceReadDto convertToDevice(Device device){
        DeviceReadDto deviceDto = new DeviceReadDto();
        deviceDto.setId(device.getId());
        deviceDto.setSerialNumber(device.getSerialNumber());
        deviceDto.setNameDevices(device.getNameDevices());
        deviceDto.setTypeDevices(device.getTypeDevices());
        deviceDto.setDataAdd(device.getDataAdd());
        return deviceDto;
    }

    public static String generateRandomPassword()
    {
        SecureRandom random = new SecureRandom();
        return random.ints(48, 123)
                .filter(i -> Character.isAlphabetic(i) || Character.isDigit(i))
                .limit(20)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
