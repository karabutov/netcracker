package com.netcracker.services;

import com.netcracker.dao.PhoneDAO;
import com.netcracker.dao.PhoneDAOImpl;
import com.netcracker.data.DataGenerator;
import com.netcracker.entities.Phone;
import com.netcracker.entities.Picture;
import com.netcracker.forms.PhoneForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PhoneService {

    @Autowired
    private PhoneDAO phoneDAO;

    public void savePhone(Phone phone){
        phoneDAO.savePhone(phone);
    }

    public Phone findPhoneWithoutPictureByModelId(Long id){
        List<Phone> phones = phoneDAO.findPhonesByModelId(id);
        for(Phone p : phones){
            if(p.getPictures() == null){
                return p;
            }
        }
        return null;
    }


    public void deletePhone(Long id){
        Phone phone = phoneDAO.findPhoneById(id);
        phoneDAO.deletePhone(phone);
    }

    public List<Phone> findAllPhones(){
        return phoneDAO.findAllPhones();
    }


    public void deletePhones(){
        List<Phone> phones = DataGenerator.getPhones();
        for(Phone p : phones) {
            phoneDAO.deletePhone(p);
        }
    }
}
