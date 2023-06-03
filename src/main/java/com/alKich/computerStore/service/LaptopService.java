package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.Laptop;

import java.util.List;

public interface LaptopService {
    List<Laptop> getAllLaptops();

    Laptop getLaptopById(Long id);

    Laptop addLaptop(Laptop laptop);

    Laptop updateLaptop(String serial, Laptop updatedLaptop);
}
