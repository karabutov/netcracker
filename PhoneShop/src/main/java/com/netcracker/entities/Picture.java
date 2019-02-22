package com.netcracker.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;

@Entity
@Table(name = "phone_shop.pictures")
@Getter
@Setter
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "picture_id")
    private Long id;


    @OneToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;


    @Column(name = "picture")
    private byte[] pictureBin;

    public String encodeImage() throws IOException, URISyntaxException {
        String file = Base64.getEncoder().encodeToString(pictureBin);
        return file;
    }


}
