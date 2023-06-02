package com.alKich.computerStore.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Monitor extends Product {
    private double diagonal;
}
