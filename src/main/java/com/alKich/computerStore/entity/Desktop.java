package com.alKich.computerStore.entity;

import com.alKich.computerStore.enums.FormFactor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
public class Desktop extends Product {
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;
}