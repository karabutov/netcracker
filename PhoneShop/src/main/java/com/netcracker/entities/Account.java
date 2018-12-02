package com.netcracker.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @OneToOne(mappedBy = "account")
    private Customer customer;

    private List<Replenishment> replenishments;

    private List<Order> orders;

    private Double curSum;

    @Setter
    @Getter
    private class Replenishment{
        private LocalDate date;
        private Double sum;
    }

}
