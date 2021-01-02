package com.nobledigitalservice.noblecrm.client.controller;


import com.nobledigitalservice.noblecrm.client.model.ClientAssests;
import com.nobledigitalservice.noblecrm.repository.ClientAssetsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/assets")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientAssetsController {


    @Autowired
    private ClientAssetsRepository clientAssetsRepository;

    private final Logger LOG = LoggerFactory.getLogger(ClientAssetsController.class);

    @PostMapping(value = "/insert")
    public void insertAssets(@RequestBody ClientAssests assets){

        LOG.info("Id = {}, AdminURL = {}, Services = {}, SiteURL = {}",assets.getId(),assets.getAdminURL(),assets.getServices(),assets.getSiteURL());
        clientAssetsRepository.save(assets);

    }


}
