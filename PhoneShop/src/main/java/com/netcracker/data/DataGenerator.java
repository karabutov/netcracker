package com.netcracker.data;

import com.netcracker.entities.Phone;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Phone> getPhones(){
        List<Phone> phones = new ArrayList<>();

        Phone p1 = new Phone();
        p1.setIsAvailable(true);
        p1.setModel("Iphone");
        p1.setPrice(100000.0);
        p1.setQuantity(20);
        p1.setId(1L);

        Phone p2 = new Phone();
        p2.setIsAvailable(true);
        p2.setModel("Samsung");
        p2.setPrice(80000.0);
        p2.setQuantity(15);
        p2.setId(2L);

        Phone p3 = new Phone();
        p3.setIsAvailable(true);
        p3.setModel("Nokia");
        p3.setPrice(60000.0);
        p3.setQuantity(11);
        p3.setId(3L);

        Phone p4 = new Phone();
        p4.setIsAvailable(true);
        p4.setModel("Vertu");
        p4.setPrice(1500000.0);
        p4.setQuantity(3);
        p4.setId(4L);

        Phone p5 = new Phone();
        p5.setIsAvailable(true);
        p5.setModel("Philips");
        p5.setPrice(15000.0);
        p5.setQuantity(23);
        p5.setId(5L);

        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);
        phones.add(p5);

        return phones;
    }
}
