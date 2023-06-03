package com.alKich.computerStore.controllers;

import com.alKich.computerStore.entity.Laptop;
import com.alKich.computerStore.service.LaptopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
@Api(value = "computer-store", tags = {"laptop"})
@AllArgsConstructor
public class LaptopController {
    private final LaptopService laptopService;

    @GetMapping
    @ApiOperation(value = "Получить список всех ноутбуков", response = Laptop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        return ResponseEntity.ok(laptopService.getAllLaptops());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получить ноутбук по id", response = Laptop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Laptop> getLaptopById(@PathVariable Long id) {
        return ResponseEntity.ok(laptopService.getLaptopById(id));
    }

    @PostMapping
    @ApiOperation(value = "Сохранить ноутбук", response = Laptop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop) {
        return ResponseEntity.ok(laptopService.addLaptop(laptop));
    }

    @PutMapping
    @ApiOperation(value = "Обновить ноутбук", response = Laptop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop) {
        return ResponseEntity.ok(laptopService.updateLaptop(laptop.getSerialNumber(), laptop));
    }
}
