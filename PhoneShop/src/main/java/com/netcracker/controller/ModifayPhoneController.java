package com.netcracker.controller;

import com.netcracker.entities.Phone;
import com.netcracker.forms.PhoneForm;
import com.netcracker.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ModifayPhoneController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/modifayphone", method = RequestMethod.GET)
    String newPhone(Model model){
        List<Phone> phones = phoneService.findAllPhones();
        model.addAttribute("phones", phones);
        model.addAttribute("phoneForm", new PhoneForm());
        return "modifyphone";
    }

}
