package org.example.service;

import org.example.model.Device;
import org.example.model.dto.DeviceDto;
import org.example.repos.DeviceRepo;
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

    private Device convertToDeviceDTO(DeviceDto deviceDto){
        Device device = new Device();
        device.setId(deviceDto.getId());
        device.setSerialNumber(deviceDto.getSerialNumber());
        device.setNameDevices(deviceDto.getNameDevices());
        deviceDto.setSecretKey(generateRandomPassword());
        device.setSecretKey(passwordEncoder.encode(deviceDto.getSecretKey()));
        device.setDataAdd(LocalDateTime.now());
        return device;
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
