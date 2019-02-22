package com.netcracker.data;

import com.netcracker.entities.Phone;
import com.netcracker.entities.PhoneModel;
import com.netcracker.entities.Picture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    static private List<Phone> phones = new ArrayList<>();
    static private List<PhoneModel> features = new ArrayList<>();
    static private List<Picture> pictures = new ArrayList<>();

    static {

        Phone p1 = new Phone();
        p1.setColor("black");
        p1.setCreation_data(LocalDate.now().minusMonths(14L));
        //p1.setModel_id(1L);
        p1.setPrice(100000.0);
        p1.setQuantity(20);
        p1.setId(1L);

        PhoneModel f1 = new PhoneModel();
        f1.setId(1L);
        f1.setBatteryCapacity(4000);
        f1.setMemory(64);
        f1.setNumOfMegapixels(12.0);
        f1.setOS("IOS");
        f1.setRAM(8);
        f1.setScreenDiagonal(5.8);
        f1.setName("iPhone X");

        Phone p2 = new Phone();
        p2.setColor("white");
        p2.setCreation_data(LocalDate.now().minusMonths(9L));
        //p2.setModel_id(2L);
        p2.setPrice(80000.0);
        p2.setQuantity(17);
        p2.setId(2L);

        PhoneModel f2 = new PhoneModel();
        f2.setId(2L);
        f2.setBatteryCapacity(5000);
        f2.setMemory(128);
        f2.setNumOfMegapixels(12.0);
        f2.setOS("Android");
        f2.setRAM(8);
        f2.setScreenDiagonal(6.0);
        f2.setName("Samsung Galaxy S9");


        Phone p3 = new Phone();
        p3.setColor("yellow");
        p3.setCreation_data(LocalDate.now().minusMonths(18L));
        //p3.setModel_id(3L);
        p3.setPrice(30000.0);
        p3.setQuantity(8);
        p3.setId(3L);

        PhoneModel f3 = new PhoneModel();
        f3.setId(3L);
        f3.setBatteryCapacity(2500);
        f3.setMemory(32);
        f3.setNumOfMegapixels(12.0);
        f3.setOS("Windows OS");
        f3.setRAM(4);
        f3.setScreenDiagonal(4.5);
        f3.setName("Nokia");

        phones.add(p1);
        phones.add(p2);
        phones.add(p3);

        features.add(f1);
        features.add(f2);
        features.add(f3);

        BufferedImage image;
    }

    public static List<Phone> getPhones(){
        return phones;
    }

    public static List<PhoneModel> getFeatures(){
        return features;
    }

    public List<Picture> getPictures() throws URISyntaxException, IOException {
        Picture pic1 = new Picture();
        pic1.setId(1L);
        //pic1.setPhoneId(1L);
        pic1.setPictureBin(Files.readAllBytes(Paths.get(this.getClass().getResource("/templates/images/black.jpg").toURI())));

        Picture pic2 = new Picture();
        pic2.setId(2L);
       // pic2.setPhoneId(2L);
        pic2.setPictureBin(Files.readAllBytes(Paths.get(this.getClass().getResource("/templates/images/white.jpg").toURI())));

        Picture pic3 = new Picture();
        pic3.setId(3L);
        //pic3.setPhoneId(3L);
        pic3.setPictureBin(Files.readAllBytes(Paths.get(this.getClass().getResource("/templates/images/yellow.jpg").toURI())));

        List<Picture> pictures = new ArrayList<>();
        pictures.add(pic1);
        pictures.add(pic2);
        pictures.add(pic3);

        return pictures;
    }
}

