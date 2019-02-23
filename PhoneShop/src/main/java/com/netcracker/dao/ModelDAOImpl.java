package com.netcracker.dao;

import com.netcracker.entities.PhoneModel;
import com.netcracker.entities.Picture;
import com.netcracker.utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ModelDAOImpl implements ModelDAO {

    @Override
    public List<PhoneModel> findByName(String name) {
        Session session = SessionFactoryUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PhoneModel> criteria = criteriaBuilder.createQuery(PhoneModel.class);
        Root<PhoneModel> from = criteria.from(PhoneModel.class);
        criteria.select(from);
        criteria.where(criteriaBuilder.equal(from.get("name"), name));
        Query<PhoneModel> q = session.createQuery(criteria);
        List<PhoneModel> res = q.list();
        session.close();
        return res;
    }

    @Override
    public void saveModel(PhoneModel model){
        Session session = SessionFactoryUtil.getSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateModel(PhoneModel model){
        Session session = SessionFactoryUtil.getSession();
        Transaction tx = session.beginTransaction();
        //session.load();
        //session.evict();
        //PhoneModel phoneModel = session.get(PhoneModel.class, model.getId());
        //phoneModel.setMemory(16);
        session.update(model);
        tx.commit();
        session.close();
    }
}