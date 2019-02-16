package com.netcracker.controller;

import com.netcracker.entities.Phone;
import com.netcracker.forms.PhoneForm;
import com.netcracker.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class AddPhoneController {

    @Autowired
    ShopService service;

    @RequestMapping("/newphone")
    String newPhone(){
        return "newphone";
    }

    @RequestMapping(value = "/addphone", method = RequestMethod.POST)
    String addPhone(Model model, @ModelAttribute("phoneForm") PhoneForm phoneForm)
            throws IOException, URISyntaxException {
        Phone newPhone = phoneForm.getPhone();
        service.addPhone(newPhone);
        return "redirect:/newphone";
    }
}
