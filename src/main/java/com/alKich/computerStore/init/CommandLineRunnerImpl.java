package com.alKich.computerStore.init;

import com.alKich.computerStore.entity.Desktop;
import com.alKich.computerStore.enums.FormFactor;
import com.alKich.computerStore.repositories.DesktopRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final DesktopRepository desktopRepository;

    @Override
    public void run(String... args) throws Exception {
        Desktop desktop = new Desktop();
        desktop.setSerialNumber("SerialNum");
        desktop.setManufacturer("China");
        desktop.setPrice(25.6);
        desktop.setQuantity(50);
        desktop.setFormFactor(FormFactor.MONOBLOCKS);
        desktopRepository.save(desktop);
    }
}
