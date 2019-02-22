package com.netcracker.services;

import com.netcracker.dao.ModelDAO;
import com.netcracker.entities.PhoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelDAO modelRepository;

    public PhoneModel findByName(String name) {
        List<PhoneModel> phoneModel = modelRepository.findByName(name);
        return phoneModel.isEmpty() ? null : phoneModel.get(0);
    }

    public void saveModel(PhoneModel model) {
        modelRepository.saveModel(model);
    }
}
