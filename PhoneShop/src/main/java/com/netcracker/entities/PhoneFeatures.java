package com.netcracker.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "phone_shop.model_characteristics")
public class PhoneFeatures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    protected Long id;

    @Column(name = "model_name")
    private String name;

    @OneToOne(mappedBy = "features")
    private Phone phone;

    @Column(name = "megapixels")
    private Double numOfMegapixels;

    @Column(name = "os")
    private String OS;

    @Column(name = "diagonal")
    private Double screenDiagonal;

    @Column(name = "battery_capacity")
    private Integer batteryCapacity;

    @Column(name = "memory")
    private Integer memory;

    @Column(name = "ram")
    private Integer RAM;

}
