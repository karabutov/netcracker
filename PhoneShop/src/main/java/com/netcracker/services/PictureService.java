package com.netcracker.services;

import com.netcracker.dao.PictureDAO;
import com.netcracker.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

    @Autowired
    PictureDAO pictureDAO;

    public void savePicture(Picture picture){
        pictureDAO.savePicture(picture);
    }

}
