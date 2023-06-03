package com.alKich.computerStore.init;

import com.alKich.computerStore.entity.*;
import com.alKich.computerStore.enums.FormFactor;
import com.alKich.computerStore.enums.LaptopSize;
import com.alKich.computerStore.repositories.DesktopRepository;
import com.alKich.computerStore.repositories.HardDriveRepository;
import com.alKich.computerStore.repositories.LaptopRepository;
import com.alKich.computerStore.repositories.MonitorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final DesktopRepository desktopRepository;
    private final LaptopRepository laptopRepository;
    private final MonitorRepository monitorRepository;
    private final HardDriveRepository hardDriveRepository;

    @Override
    public void run(String... args) {
        Desktop desktop = new Desktop();
        addDefault1(desktop);
        desktop.setFormFactor(FormFactor.MONOBLOCKS);
        desktopRepository.save(desktop);

        Desktop desktop2 = new Desktop();
        addDefault2(desktop2);
        desktop2.setFormFactor(FormFactor.NETTOPS);
        desktopRepository.save(desktop2);

        Laptop laptop = new Laptop();
        addDefault1(laptop);
        laptop.setLaptopSize(LaptopSize.SIZE_17);
        laptopRepository.save(laptop);

        Laptop laptop2 = new Laptop();
        addDefault2(laptop2);
        laptop2.setLaptopSize(LaptopSize.SIZE_17);
        laptopRepository.save(laptop2);

        Monitor monitor = new Monitor();
        addDefault1(monitor);
        monitor.setDiagonal(15.6);
        monitorRepository.save(monitor);

        Monitor monitor2 = new Monitor();
        addDefault2(monitor2);
        monitor2.setDiagonal(35.6);
        monitorRepository.save(monitor2);

        HardDrive hardDrive = new HardDrive();
        addDefault1(hardDrive);
        hardDrive.setCapacity(256.4);
        hardDriveRepository.save(hardDrive);

        HardDrive hardDrive2 = new HardDrive();
        addDefault2(hardDrive2);
        hardDrive2.setCapacity(128.8);
        hardDriveRepository.save(hardDrive2);
    }

    private void addDefault1(Product product) {
        product.setSerialNumber("SerialNum1");
        product.setManufacturer("China");
        product.setPrice(25.6);
        product.setQuantity(50);
    }

    private void addDefault2(Product product) {
        product.setSerialNumber("SerialNum2");
        product.setManufacturer("France");
        product.setPrice(37.6);
        product.setQuantity(88);
    }


}
