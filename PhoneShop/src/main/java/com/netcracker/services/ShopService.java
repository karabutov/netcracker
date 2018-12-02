package com.netcracker.services;

import com.netcracker.dao.PhoneDAOImpl;
import com.netcracker.data.DataGenerator;
import com.netcracker.entities.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShopService {

    @Autowired
    private PhoneDAOImpl phoneDAO;

    public void addPhone(Phone phone){
        phoneDAO.addPhone(phone);
    }

    public void deletePhone(Phone phone){
        phoneDAO.deletePhone(phone);
    }

    public List<Phone> findAllPhones(){
        return phoneDAO.findAllPhones();
    }

    public void addPhones(){
        List<Phone> phones = DataGenerator.getPhones();
        for(Phone p : phones) {
            phoneDAO.addPhone(p);
        }
    }

    public void deletePhones(){
        List<Phone> phones = DataGenerator.getPhones();
        for(Phone p : phones) {
            phoneDAO.deletePhone(p);
        }
    }
}
