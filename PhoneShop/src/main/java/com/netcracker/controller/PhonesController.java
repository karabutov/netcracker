package com.netcracker.controller;

import com.netcracker.entities.Phone;
import com.netcracker.repositories.PhoneRepository;
import com.netcracker.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class PhonesController {

    private ShopService service;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    public PhonesController(ShopService service){
        this.service = service;
    }

    @RequestMapping("deletephone")
    public String deletePhone(Model model, @RequestParam(name="phoneId")long phoneId){
        service.deletePhone(phoneId);
        //phoneRepository.deleteById(phoneId);
        //Iterable<Phone> phones = phoneRepository.findAll();
        return"redirect:/phones";
    }

    @RequestMapping("/phones")
    String getPhone(Model model) {
        List<Phone> phones = service.findAllPhones();
        //Iterable<Phone> phones = phoneRepository.findAll();
        model.addAttribute("phones", phones);
        return "phones";
    }

    @RequestMapping("/picture")
    public void addPicture() throws Exception {
        service.addPhones();
    }


/*
    @RequestMapping("/findallphones")
    public List<Phone> findAllPhones(){
        return service.findAllPhones();
    }

    @RequestMapping("/addphones")
    public void addPhones()throws Exception{
        service.addPhones();
    }

    @RequestMapping("/addphone")
    public void addPhone(Phone phone){
        service.addPhone(phone);
    }

    @RequestMapping("/deletephones")
    public void deletePhones(){
        service.deletePhones();
    }
*/

}