package com.netcracker.controller;

import com.netcracker.entities.Phone;
import com.netcracker.entities.PhoneModel;
import com.netcracker.forms.PhoneForm;
import com.netcracker.services.ModelService;
import com.netcracker.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ModifayPhoneController {

    @Autowired
    private PhoneService phoneService;

    @Autowired
    ModelService modelService;

    @RequestMapping(value = "/modifayphone", method = RequestMethod.GET)
    String getPhone(Model model, @RequestParam(name="phoneId")Long phoneId){
        Phone phone = phoneService.findPhoneById(phoneId);
        PhoneForm phoneForm = new PhoneForm(phone);
        model.addAttribute("phoneForm", phoneForm);
        return "modifyphone";
    }

    @RequestMapping(value = "/modifayphone", method = RequestMethod.POST)
    String modifayPhone(Model model, @ModelAttribute PhoneForm phoneForm){
        PhoneModel phoneModel = phoneForm.getPhoneModel();
        modelService.updateModel(phoneModel);
        Phone phone = phoneForm.getPhone(phoneModel);
        phoneService.updatePhone(phone);
        return "redirect:/phones";
    }

}
