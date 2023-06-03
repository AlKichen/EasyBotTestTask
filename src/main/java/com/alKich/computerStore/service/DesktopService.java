package com.alKich.computerStore.service;

import com.alKich.computerStore.entity.Desktop;

import java.util.List;

public interface DesktopService {
    List<Desktop> getAllDesktops();

    Desktop getDesktopById(Long id);

    Desktop addDesktop(Desktop desktop);

    Desktop updateDesktop(String serialNumber, Desktop updatedDesktop);
}
