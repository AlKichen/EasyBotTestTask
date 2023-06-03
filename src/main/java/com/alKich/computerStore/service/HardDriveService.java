package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.HardDrive;

import java.util.List;

public interface HardDriveService {
    List<HardDrive> getAllHardDrives();

    HardDrive getHardDriveById(Long id);

    HardDrive addHardDrive(HardDrive hardDrive);

    HardDrive updateHardDrive(Long id, HardDrive updatedHardDrive);
}
