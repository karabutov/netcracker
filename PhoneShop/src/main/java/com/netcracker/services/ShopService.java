package com.netcracker.services;

import com.netcracker.dao.PhoneDAOImpl;
import com.netcracker.data.DataGenerator;
import com.netcracker.entities.Phone;
import com.netcracker.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShopService {

    @Autowired
    private PhoneDAOImpl phoneDAO;

    public void addPhone(Phone phone){
        phoneDAO.addPhone(phone);
    }

    public void deletePhone(Long id){
        Phone phone = phoneDAO.findPhoneById(id);
        phoneDAO.deletePhone(phone);
    }

    public List<Phone> findAllPhones(){
        return phoneDAO.findAllPhones();
    }

    public void addPhones() throws Exception{

        DataGenerator dataGenerator = new DataGenerator();
        List<Picture> pictures = dataGenerator.getPictures();
        for(Picture pic : pictures){
            phoneDAO.addPicture(pic);
        }


        /*
        List<Phone> phones = DataGenerator.getPhones();
        for(Phone p : phones) {
            phoneDAO.addPhone(p);
        }*/
    }

    public void deletePhones(){
        List<Phone> phones = DataGenerator.getPhones();
        for(Phone p : phones) {
            phoneDAO.deletePhone(p);
        }
    }
}
