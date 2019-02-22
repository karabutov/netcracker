package com.netcracker.dao;

import com.netcracker.entities.Picture;
import com.netcracker.utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PictureDAOImpl implements PictureDAO {

    @Override
    public void savePicture(Picture picture){
        Session session = SessionFactoryUtil.getSession();
        session.beginTransaction();
        session.save(picture);
        session.getTransaction().commit();
        session.close();
    }

}
