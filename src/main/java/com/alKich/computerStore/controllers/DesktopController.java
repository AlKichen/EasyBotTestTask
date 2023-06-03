package com.alKich.computerStore.controllers;

import com.alKich.computerStore.entity.Desktop;
import com.alKich.computerStore.service.DesktopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/desktops")
@Api(value = "computer-store", tags = {"desktop"})
@AllArgsConstructor
public class DesktopController {
    private final DesktopService desktopService;

    @GetMapping
    @ApiOperation(value = "Получить список всех мониторов", response = Desktop.class)
    public ResponseEntity<List<Desktop>> getAllDesktops() {
        return ResponseEntity.ok(desktopService.getAllDesktops());
    }
}
