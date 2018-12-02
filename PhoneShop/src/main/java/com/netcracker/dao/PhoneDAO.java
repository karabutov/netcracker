package com.netcracker.dao;

import com.netcracker.entities.Phone;

import java.util.List;

public interface PhoneDAO {

    void addPhone(Phone phone);

    void deletePhone(Phone phone);

    List<Phone> findAllPhones();

}
