package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.Laptop;
import com.alKich.computerStore.exception.ResourceNotFoundException;
import com.alKich.computerStore.repositories.LaptopRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Laptop not found, id:" + id));
    }

    @Override
    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop updateLaptop(String serial, Laptop updatedLaptop) {
        Laptop laptop = laptopRepository.findBySerialNumber(serial).orElseThrow(
                () -> new ResourceNotFoundException("Desktop not found, serial number:" + serial)
        );
        updatedLaptop.setId(laptop.getId());
        modelMapper.map(updatedLaptop, laptop);
        return laptopRepository.save(laptop);
    }
}
