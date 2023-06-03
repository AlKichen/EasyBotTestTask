package com.alKich.computerStore.repositories;

import com.alKich.computerStore.entity.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop, Long> {
    public Optional<Desktop> findBySerialNumber(String serialNumber);

}