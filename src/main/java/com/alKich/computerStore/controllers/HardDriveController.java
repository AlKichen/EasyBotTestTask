package com.alKich.computerStore.controllers;

import com.alKich.computerStore.entity.HardDrive;
import com.alKich.computerStore.service.HardDriveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hard_drivers")
@Api(value = "computer-store", tags = {"hard_driver"})
@AllArgsConstructor
public class HardDriveController {
    private final HardDriveService hardDriveService;

    @GetMapping
    @ApiOperation(value = "Получить список всех жестких дисков", response = HardDrive.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<List<HardDrive>> getAllHardDrivers() {
        return ResponseEntity.ok(hardDriveService.getAllHardDrives());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получить жесткий диск по id", response = HardDrive.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<HardDrive> getHardDriveById(@PathVariable Long id) {
        return ResponseEntity.ok(hardDriveService.getHardDriveById(id));
    }

    @PostMapping
    @ApiOperation(value = "Сохранить жесткий диск", response = HardDrive.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<HardDrive> addHardDrive(@RequestBody HardDrive hardDrive) {
        return ResponseEntity.ok(hardDriveService.addHardDrive(hardDrive));
    }

    @PutMapping
    @ApiOperation(value = "Обновить жесткий диск", response = HardDrive.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<HardDrive> updateHardDrive(@RequestBody HardDrive hardDrive) {
        return ResponseEntity.ok(hardDriveService.updateHardDrive(hardDrive.getSerialNumber(), hardDrive));
    }
}
