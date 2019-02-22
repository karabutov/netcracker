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

    private String modelName;

    private Double numOfMegapixels;

    private String OS;

    private Double screenDiagonal;

    private Integer batteryCapacity;

    private Integer memory;

    private Integer RAM;

    private File pictures ;
   //private MultipartFile picture;

    private Double price;

    private String color;

    private Integer quantity;



    private final static String IMAGES = "/images/";

    public Phone getPhone(PhoneModel model) {
        Phone phone = new Phone();
        phone.setCreation_data(LocalDate.now());
        phone.setColor(color);
        phone.setPrice(price);
        phone.setQuantity(quantity);
        phone.setModel(model);
        phone.setPictures(getPicture());
        return phone;
    }

    public PhoneModel getPhoneModel(){
        PhoneModel PhoneModel = new PhoneModel();
        PhoneModel.setName(modelName);
        PhoneModel.setScreenDiagonal(screenDiagonal);
        PhoneModel.setOS(OS);
        PhoneModel.setBatteryCapacity(batteryCapacity);
        PhoneModel.setMemory(memory);
        PhoneModel.setNumOfMegapixels(numOfMegapixels);
        PhoneModel.setRAM(RAM);
        return PhoneModel;
    }

    public Picture getPicture() {
        Picture picture = new Picture();
        String name = pictures.getName();
      /*  name = pictures.getOriginalFilename();
        name = IMAGES + pictures.getName();
        pictures.transferTo(new File(IMAGES + pictures.getName()));
    */
        try {
            picture.setPictureBin(Files.readAllBytes(Paths.get(this.getClass().getResource("/images/empty.jpg").toURI())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return picture;
    }

}
