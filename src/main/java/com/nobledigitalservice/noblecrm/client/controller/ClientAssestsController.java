package com.nobledigitalservice.noblecrm.client.controller;


import com.nobledigitalservice.noblecrm.client.service.ClientAssetsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/assets")
public class ClientAssestsController {


//    @Autowired
//    private ClientAssetsRepository clientAssetsRepository;

    @PostMapping(value = "/insert")
    public void insertAssests(@RequestBody ClientAssetsService assets){

//        clientAssetsRepository.save(assets);

    }


}
