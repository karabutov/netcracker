package com.netcracker.dao;

import com.netcracker.entities.PhoneModel;

import java.util.List;


public interface ModelDAO {

    List<PhoneModel> findByName(String name);
    void saveModel(PhoneModel model);
    void updateModel(PhoneModel model);

}
