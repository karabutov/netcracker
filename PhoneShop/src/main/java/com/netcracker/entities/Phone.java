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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "phone_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model")
    private PhoneModel model;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    private Picture pictures ;//= new ArrayList<>();*/

    @Column(name = "price")
    private Double price;

    @Column(name = "color")
    private String color;

    @Column(name = "creation_data")
    private LocalDate creation_data;

    @Column(name = "quantity")
    private Integer quantity;

}
