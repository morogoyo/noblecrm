package com.nobledigitalservice.noblecrm.client.controller;


import com.nobledigitalservice.noblecrm.client.model.ClientAssets;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/assets")
public class ClientAssestsController {


//    @Autowired
//    private ClientAssetsService clientAssetsService;

    @PostMapping(value = "/insert")
    public String insertAssets(@RequestBody ClientAssets assets){
//        UserDTO user = clientAssetsService.findByEmail(assets.getEmail());
//        System.out.println(user.toString());

        return "Rene is a bad ass";

    }


}
