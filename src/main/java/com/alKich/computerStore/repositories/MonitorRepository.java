package com.alKich.computerStore.repositories;

import com.alKich.computerStore.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    Optional<Monitor> findBySerialNumber(String serialNumber);
}
