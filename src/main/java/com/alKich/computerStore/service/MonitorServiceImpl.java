package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.Laptop;
import com.alKich.computerStore.entity.Monitor;
import com.alKich.computerStore.exception.ResourceNotFoundException;
import com.alKich.computerStore.repositories.MonitorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonitorServiceImpl implements MonitorService {
    private final MonitorRepository monitorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    @Override
    public Monitor getMonitorById(Long id) {
        return monitorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Monitor not found, id:" + id));
    }

    @Override
    public Monitor addMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    @Override
    public Monitor updateMonitor(String serial, Monitor updatedMonitor) {
        Monitor monitor = monitorRepository.findBySerialNumber(serial).orElseThrow(
                () -> new ResourceNotFoundException("Desktop not found, serial number:" + serial)
        );
        updatedMonitor.setId(monitor.getId());
        modelMapper.map(updatedMonitor, monitor);
        return monitorRepository.save(monitor);
    }
}
