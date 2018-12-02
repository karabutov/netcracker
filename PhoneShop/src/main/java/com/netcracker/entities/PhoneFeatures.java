package com.netcracker.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Table(appliesTo = "phones")
public class PhoneFeatures extends Phone {

    @Column(name = "color")
    private String color;

    @Column(name = "megapixels")
    private double numOfMegapixels;

    @Column(name = "os")
    private String OS;

    @Column(name = "screen_diagonal")
    private Double screenDiagonal;

    @Column(name = "memory")
    private Double memory;

    @Column(name = "ram")
    private Double RAM;

    @Column(name = "battery_capacity")
    private Integer batteryCapacity;

    @Column(name = "year")
    private Integer year;

    @Column(name = "quantity")
    private Integer quantity;
}
