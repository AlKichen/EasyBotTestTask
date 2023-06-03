package com.alKich.computerStore.repositories;

import com.alKich.computerStore.entity.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop, Long> {

}