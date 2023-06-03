package com.alKich.computerStore.controllers;

import com.alKich.computerStore.entity.Desktop;
import com.alKich.computerStore.service.DesktopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desktops")
@Api(value = "computer-store", tags = {"desktop"})
@AllArgsConstructor
public class DesktopController {
    private final DesktopService desktopService;

    @GetMapping
    @ApiOperation(value = "Получить список всех ПК", response = Desktop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<List<Desktop>> getAllDesktops() {
        return ResponseEntity.ok(desktopService.getAllDesktops());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получить ПК по id", response = Desktop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Desktop> getDesktopById(@PathVariable Long id) {
        return ResponseEntity.ok(desktopService.getDesktopById(id));
    }

    @PostMapping
    @ApiOperation(value = "Сохранить ПК", response = Desktop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Desktop> addDesktop(@RequestBody Desktop desktop) {
        return ResponseEntity.ok(desktopService.addDesktop(desktop));
    }

    @PutMapping
    @ApiOperation(value = "Обновить ПК", response = Desktop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Desktop> updateHistory(@RequestBody Desktop desktop) {
        return ResponseEntity.ok(desktopService.updateDesktop(desktop.getSerialNumber(), desktop));
    }
}
