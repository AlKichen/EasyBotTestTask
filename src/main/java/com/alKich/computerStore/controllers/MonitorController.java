package com.alKich.computerStore.controllers;

import com.alKich.computerStore.entity.Monitor;
import com.alKich.computerStore.service.MonitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitors")
@Api(value = "computer-store", tags = {"monitor"})
@AllArgsConstructor
public class MonitorController {
    private final MonitorService monitorService;

    @GetMapping
    @ApiOperation(value = "Получить список всех мониторов", response = Monitor.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<List<Monitor>> getAllMonitors() {
        return ResponseEntity.ok(monitorService.getAllMonitors());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получить монитор по id", response = Monitor.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Monitor> getMonitorById(@PathVariable Long id) {
        return ResponseEntity.ok(monitorService.getMonitorById(id));
    }

    @PostMapping
    @ApiOperation(value = "Сохранить монитор", response = Monitor.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Monitor> addMonitor(@RequestBody Monitor monitor) {
        return ResponseEntity.ok(monitorService.addMonitor(monitor));
    }

    @PutMapping
    @ApiOperation(value = "Обновить монитор", response = Monitor.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Monitor> updateMonitor(@RequestBody Monitor monitor) {
        return ResponseEntity.ok(monitorService.updateMonitor(monitor.getSerialNumber(), monitor));
    }
}
