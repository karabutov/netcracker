package com.netcracker.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "phone_shop.model_characteristics")
public class PhoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "model")
    private List<Phone> phones;

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
