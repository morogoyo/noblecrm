package com.nobledigitalservice.noblecrm.client.controllers;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import com.nobledigitalservice.noblecrm.client.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping(value = "/client")
public class ClientController {

    private final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/all",produces = "application/json")
    public ResponseEntity<?> getAllClient() {
//        LOG.info("got to the controllers");

        List<UserDTO> users = clientService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/find-client")
    public ResponseEntity<?> findClient(@RequestBody UserDTO user) {

        Optional<UserDTO> client = clientService.getUser(user);
        if (!client.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(client.get(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addClient(@RequestBody UserDTO user) {
        clientService.addUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClientInfo(@RequestBody UserDTO updatedUser) {
        // TODO update user with in service client service
        Optional<UserDTO> updatedUserInfo = clientService.updateUser(updatedUser);
        if (!updatedUserInfo.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedUserInfo, HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity<?> deleteClient(@RequestBody UserDTO userToDelet){
        clientService.deleteUser(userToDelet);
        Optional<UserDTO> checkUser = Optional.ofNullable(userToDelet);

        if(!checkUser.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(userToDelet.toString() + "was deleted",HttpStatus.OK);
        }
    }

}
