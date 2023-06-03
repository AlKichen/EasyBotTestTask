package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.Desktop;
import com.alKich.computerStore.exception.ResourceNotFoundException;
import com.alKich.computerStore.repositories.DesktopRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DesktopServiceImpl implements DesktopService {

    private final DesktopRepository desktopRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Desktop> getAllDesktops() {
        return desktopRepository.findAll();
    }

    @Override
    public Desktop getDesktopById(Long id) {
        return desktopRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Desktop not found, id:" + id));
    }

    @Override
    public Desktop addDesktop(Desktop desktop) {
        return desktopRepository.save(desktop);
    }

    @Override
    public Desktop updateDesktop(Long id, Desktop updatedDesktop) {
        Desktop desktop = getDesktopById(id);
        modelMapper.map(updatedDesktop, desktop);
        return desktopRepository.save(desktop);
    }
}
