package com.nobledigitalservice.noblecrm.asset_admin.controller;


import com.nobledigitalservice.noblecrm.asset_admin.model.AdminURLs;
import com.nobledigitalservice.noblecrm.repository.AdminURLsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminURLsControllers {

    @Autowired
    private AdminURLsRepository adminURLsRepo;

    @GetMapping(value = "/all")
    public List<AdminURLs> getAllURLs(){

       return  adminURLsRepo.findAll();
    }
}
