package com.netcracker.controller;

import com.netcracker.entities.Phone;
import com.netcracker.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/phoneshop")
public class ServerController {

    private ShopService service;

    @Autowired
    public ServerController(ShopService service){
        this.service = service;
    }

    @RequestMapping("/addphone")
    public void addPhone(Phone phone){
        service.addPhone(phone);
    }

    @RequestMapping("deletephone")
    public void deletePhone(Phone phone){
        service.deletePhone(phone);
    }

    @RequestMapping("/findallphones")
    public List<Phone> findAllPhones(){
        return service.findAllPhones();
    }

    @RequestMapping("/addphones")
    public void addPhones(){
        service.addPhones();
    }

    @RequestMapping("/deletephones")
    public void deletePhones(){
        service.deletePhones();
    }

    @RequestMapping("/phones")
    String getPhone(Model model) {
        List<Phone> phones = service.findAllPhones();
        model.addAttribute("phones", phones);
        return "phones";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
}