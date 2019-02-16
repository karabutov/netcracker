package com.netcracker.forms;

import com.netcracker.entities.Phone;
import com.netcracker.entities.PhoneFeatures;
import com.netcracker.entities.Picture;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class PhoneForm {

    private String modelName;

    private Double numOfMegapixels;

    private String OS;

    private Double screenDiagonal;

    private Integer batteryCapacity;

    private Integer memory;

    private Integer RAM;

    private File pictures ;

    private Double price;

    private String color;

    private Integer quantity;

    public Phone getPhone() throws URISyntaxException, IOException {
        Phone phone = new Phone();
        phone.setCreation_data(LocalDate.now());
        phone.setColor(color);
        phone.setPrice(price);
        phone.setQuantity(quantity);

        PhoneFeatures phoneFeatures = new PhoneFeatures();
        phoneFeatures.setName(modelName);
        phoneFeatures.setScreenDiagonal(screenDiagonal);
        phoneFeatures.setOS(OS);
        phoneFeatures.setBatteryCapacity(batteryCapacity);
        phoneFeatures.setMemory(memory);
        phoneFeatures.setNumOfMegapixels(numOfMegapixels);
        phoneFeatures.setRAM(RAM);
        phoneFeatures.setPhone(phone);

        Picture picture = new Picture();
        picture.setPictureBin(Files.readAllBytes(Paths.get(this.getClass().getResource(pictures.getPath()).toURI())));

        phone.setPictures(picture);

        return phone;

    }

}
