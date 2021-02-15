package com.nobledigitalservice.noblecrm.asset_admin.controller;


import com.nobledigitalservice.noblecrm.asset_admin.model.AdminURLs;
import com.nobledigitalservice.noblecrm.repository.AdminURLsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/update")
    public AdminURLs updateURL(@RequestBody AdminURLs url){
        AdminURLs editeUrl = null;
        adminURLsRepo.findById(url.getEmail());
        editeUrl.setUrl(url.getUrl());
        editeUrl.setEmail(url.getEmail());
        editeUrl.setId(url.getId());
        return adminURLsRepo.save(editeUrl);
    }

    @PostMapping(value = "/add")
    public AdminURLs addURL(@RequestBody AdminURLs url){
        return adminURLsRepo.save(url);
    }
}
