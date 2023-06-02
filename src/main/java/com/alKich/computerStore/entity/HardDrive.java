package com.alKich.computerStore.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class HardDrive extends Product {
    private double capacity;
}
