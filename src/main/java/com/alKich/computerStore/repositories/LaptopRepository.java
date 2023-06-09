package com.alKich.computerStore.repositories;

import com.alKich.computerStore.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Optional<Laptop> findBySerialNumber(String serialNumber);
}
