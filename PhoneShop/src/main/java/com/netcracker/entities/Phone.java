package com.netcracker.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "phone_shop.products")
@Getter
@Setter
public class Phone {

    public Phone(){}

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    protected Long id;


    @Column(name = "model")
    protected String model;


    @Column(name = "price")
    protected Double price;

    @Column(name = "quantity")
    protected Integer quantity;

    @Column(name = "is_available")
    protected Boolean isAvailable;

}
