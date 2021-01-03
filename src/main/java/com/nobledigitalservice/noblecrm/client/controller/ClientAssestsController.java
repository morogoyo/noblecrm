package com.nobledigitalservice.noblecrm.client.controller;


import com.nobledigitalservice.noblecrm.client.service.ClientAssetsService;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/assets")
public class ClientAssestsController {


//    @Autowired
//    private ClientAssetsRepository clientAssetsRepository;

    @PostMapping(value = "/insert")
    public void insertAssests(@RequestBody ClientAssetsService assets){

//        clientAssetsRepository.save(assets);

    }


}
