package com.netcracker.dao;

import com.netcracker.entities.Phone;
import com.netcracker.entities.PhoneModel;
import com.netcracker.entities.Picture;
import com.netcracker.utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PhoneDAOImpl implements PhoneDAO{


   @Override
   public void savePhone(Phone phone) {
      Session session = SessionFactoryUtil.getSession();
      session.beginTransaction();
      session.save(phone);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public void updatePhone(Phone phone){
      Session session = SessionFactoryUtil.getSession();
      session.beginTransaction();
      session.update(phone);
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

   @Override
   public Phone findPhoneById(Long id) {
      Session session = SessionFactoryUtil.getSession();
      Phone res = session.get(Phone.class, id);
      session.close();
      return res;
   }

   @Override
   public List<Phone> findPhonesByModelId(Long id){
      Session session = SessionFactoryUtil.getSession();
      CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
      CriteriaQuery<Phone> criteria = criteriaBuilder.createQuery(Phone.class);
      Root<Phone> from = criteria.from(Phone.class);
      criteria.select(from);
      criteria.where(criteriaBuilder.equal(from.get("model"), id));
      Query<Phone> q = session.createQuery(criteria);
      List<Phone> res = q.list();
      session.close();
      return res;
   }

}
