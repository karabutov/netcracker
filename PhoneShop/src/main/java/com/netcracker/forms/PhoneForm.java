package com.netcracker.forms;

import com.netcracker.entities.Phone;
import com.netcracker.entities.PhoneModel;
import com.netcracker.entities.Picture;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class PhoneForm {

    private Long phoneId;

    private Long modelId;

    private Long pictureId;

    private String modelName;

    private Double numOfMegapixels;

    private String OS;

    private Double screenDiagonal;

    private Integer batteryCapacity;

    private Integer memory;

    private Integer RAM;

    private MultipartFile pictures;

    private Double price;

    private String color;

    private Integer quantity;



    private final static String IMAGE = "/images/empty.jpg";

    public PhoneForm(Phone phone){

        PhoneModel model = phone.getModel();
        modelId = model.getId();
        modelName = model.getName();
        numOfMegapixels = model.getNumOfMegapixels();
        OS = model.getOS();
        screenDiagonal = model.getScreenDiagonal();
        batteryCapacity = model.getBatteryCapacity();
        memory = model.getMemory();
        RAM = model.getRAM();

        phoneId = phone.getId();
        price = phone.getPrice();
        color = phone.getColor();
        quantity = phone.getQuantity();

        pictureId = phone.getPictures().getId();
    }

    public Phone getPhone(PhoneModel model) {
        Phone phone = new Phone();
        phone.setId(phoneId);
        phone.setCreation_data(LocalDate.now());
        phone.setColor(color);
        phone.setPrice(price);
        phone.setQuantity(quantity);
        phone.setModel(model);
        return phone;
    }

    public PhoneModel getPhoneModel(){
        PhoneModel phoneModel = new PhoneModel();
        phoneModel.setId(modelId);
        phoneModel.setName(modelName);
        phoneModel.setScreenDiagonal(screenDiagonal);
        phoneModel.setOS(OS);
        phoneModel.setBatteryCapacity(batteryCapacity);
        phoneModel.setMemory(memory);
        phoneModel.setNumOfMegapixels(numOfMegapixels);
        phoneModel.setRAM(RAM);
        return phoneModel;
    }

    public Picture getPicture(Phone phone) {
        Picture picture = new Picture();
        picture.setId(pictureId);
        picture.setPhone(phone);
        try {
            if(pictures == null){
                picture.setPictureBin(pictures.getBytes());
            } else{
                picture.setPictureBin(Files.readAllBytes(Paths.get(this.getClass().getResource(IMAGE).toURI())));
            }
        } catch (Exception e) {
            return picture;
        }
        return picture;
    }

}
