package com.netcracker.services;

import com.netcracker.dao.ModelDAO;
import com.netcracker.entities.PhoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelDAO modelDAO;

    public PhoneModel findByName(String name) {
        List<PhoneModel> phoneModel = modelDAO.findByName(name);
        return phoneModel.isEmpty() ? null : phoneModel.get(0);
    }

    public void saveModel(PhoneModel model) {
        modelDAO.saveModel(model);
    }

    public void updateModel(PhoneModel phoneModel){
        modelDAO.updateModel(phoneModel);
    }
}
