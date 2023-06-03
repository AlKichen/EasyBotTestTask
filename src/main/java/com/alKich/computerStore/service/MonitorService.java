package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.Monitor;

import java.util.List;

public interface MonitorService {
    List<Monitor> getAllMonitors();

    Monitor getMonitorById(Long id);

    Monitor addMonitor(Monitor monitor);

    Monitor updateMonitor(String serial, Monitor updatedMonitor);
}
