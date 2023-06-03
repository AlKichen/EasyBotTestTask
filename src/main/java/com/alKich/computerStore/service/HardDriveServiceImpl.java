package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.HardDrive;
import com.alKich.computerStore.exception.ResourceNotFoundException;
import com.alKich.computerStore.repositories.HardDriveRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardDriveServiceImpl implements HardDriveService {
    private final HardDriveRepository hardDriveRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<HardDrive> getAllHardDrives() {
        return hardDriveRepository.findAll();
    }

    @Override
    public HardDrive getHardDriveById(Long id) {
        return hardDriveRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("HardDrive not found, id:" + id));
    }

    @Override
    public HardDrive addHardDrive(HardDrive hardDrive) {
        return hardDriveRepository.save(hardDrive);
    }

    @Override
    public HardDrive updateHardDrive(String serial, HardDrive updatedHardDrive) {
        HardDrive hardDrive = hardDriveRepository.findBySerialNumber(serial).orElseThrow(
                () -> new ResourceNotFoundException("Desktop not found, serial number:" + serial)
        );
        updatedHardDrive.setId(hardDrive.getId());
        modelMapper.map(updatedHardDrive, hardDrive);
        return hardDriveRepository.save(hardDrive);
    }
}
