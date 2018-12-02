package com.netcracker.dao;

import com.netcracker.entities.Phone;
import com.netcracker.utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneDAOImpl implements PhoneDAO{

   @Override
   public void addPhone(Phone phone) {
      Session session = SessionFactoryUtil.getSession();
      session.beginTransaction();
      session.save(phone);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public void deletePhone(Phone phone) {
      Session session = SessionFactoryUtil.getSession();
      session.beginTransaction();
      session.delete(phone);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public List<Phone> findAllPhones() {
      Session session = SessionFactoryUtil.getSession();
      List<Phone> res = session.createQuery("from Phone").list();
      session.close();
      return res;
   }

}
