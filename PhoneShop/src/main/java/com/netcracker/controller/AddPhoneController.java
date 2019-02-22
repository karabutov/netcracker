package com.netcracker.controller;

import com.netcracker.entities.Phone;
import com.netcracker.entities.PhoneModel;
import com.netcracker.forms.PhoneForm;
import com.netcracker.services.ModelService;
import com.netcracker.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPhoneController {

    @Value("${images.dir.path}")
    private String imagesPath;


    @Autowired
    private ModelService modelService;

    @Autowired
    private PhoneService phoneService;


    @RequestMapping("/newphone")
    String newPhone(Model model){
        model.addAttribute("phoneForm", new PhoneForm());
        return "newphone";
    }

    @RequestMapping(value = "/addphone", method = RequestMethod.POST)
    String addPhone(Model model, @ModelAttribute("phoneForm") PhoneForm phoneForm) {

        PhoneModel phoneModel = modelService.findByName(phoneForm.getModelName());
        if(phoneModel == null){
            modelService.saveModel(phoneForm.getPhoneModel());
            phoneModel = modelService.findByName(phoneForm.getModelName());
        }
        Phone newPhone = phoneForm.getPhone(phoneModel);
        phoneService.addPhone(newPhone);
        return "redirect:/newphone";
    }
}
