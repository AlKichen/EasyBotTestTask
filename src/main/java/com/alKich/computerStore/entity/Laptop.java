package com.alKich.computerStore.entity;

import com.alKich.computerStore.enums.LaptopSize;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
public class Laptop extends Product {
    @Enumerated(EnumType.STRING)
    private LaptopSize laptopSize;
}
