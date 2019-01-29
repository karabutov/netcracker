package com.netcracker.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "phone_shop.phones")
@Getter
@Setter
public class Phone {

    public Phone() {
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "model_id")
    private PhoneFeatures features;

/*
    @Column(name = "model_id")
    private Long model_id;
*/

    @Column(name = "price")
    private Double price;

    @Column(name = "color")
    private String color;

    @Column(name = "creation_data")
    private LocalDate creation_data;

    @Column(name = "quantity")
    private Integer quantity;

}
