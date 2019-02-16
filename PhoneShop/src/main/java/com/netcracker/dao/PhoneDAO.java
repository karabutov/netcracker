package com.netcracker.dao;

import com.netcracker.entities.Phone;
import com.netcracker.entities.Picture;

import java.util.List;

public interface PhoneDAO {

    void addPhone(Phone phone);

    void addPicture(Picture picture);

    void deletePhone(Phone phone);

    List<Phone> findAllPhones();

    Phone findPhoneById(Long id);

}
