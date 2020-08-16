package com.nobledigitalservice.noblecrm.client.controller;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import com.nobledigitalservice.noblecrm.client.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/client")
public class Client {

    private final Logger LOG = LoggerFactory.getLogger(Client.class);

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllClient() {
//        LOG.info("got to the controller");

        List<UserDTO> users =  clientService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserDTO user){
        clientService.addUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserDTO updatedUser){
        // TODO update user with in service client service


        return new ResponseEntity<>();
    }


}
