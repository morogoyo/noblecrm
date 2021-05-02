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

    @PostMapping(value = "/add-urls")
    public AdminURLs addAdminUrl(@RequestBody AdminURLs adminURLs){
        AdminURLs newUrl = adminURLsRepo.save(adminURLs);
        return newUrl;
    }


//    @PutMapping(value = "/update")
//    public AdminURLs updateURL(@RequestBody AdminURLs url){
//        AdminURLs editedUrl = null;
//        adminURLsRepo.findById(url.getEmail());
//        editedUrl.setUrl(url.getUrl());
//        editedUrl.setEmail(url.getEmail());
//        editedUrl.setId(url.getId());
//        return adminURLsRepo.save(editedUrl);
//    }

    @PostMapping(value = "/add")
    public AdminURLs addURL(@RequestBody AdminURLs url){
        return adminURLsRepo.save(url);
    }
}
