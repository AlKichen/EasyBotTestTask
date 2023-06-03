package com.alKich.computerStore.repositories;

import com.alKich.computerStore.entity.HardDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDrive, Long> {
}
