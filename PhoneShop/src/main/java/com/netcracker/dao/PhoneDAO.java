package com.netcracker.dao;

import com.netcracker.entities.Phone;
import com.netcracker.entities.Picture;

import java.util.List;

public interface PhoneDAO {

    void savePhone(Phone phone);

    void updatePhone(Phone phone);

    void deletePhone(Phone phone);

    List<Phone> findAllPhones();

    Phone findPhoneById(Long id);

    List<Phone> findPhonesByModelId(Long id);



}
