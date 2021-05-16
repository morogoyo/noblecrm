package com.nobledigitalservice.noblecrm.client.controllers;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
<<<<<<< HEAD:src/main/java/com/nobledigitalservice/noblecrm/client/controller/ClientController.java
import com.nobledigitalservice.noblecrm.client.service.ClientService;
import com.nobledigitalservice.noblecrm.repository.UserInfoRepository;
=======
import com.nobledigitalservice.noblecrm.client.services.ClientService;
>>>>>>> master:src/main/java/com/nobledigitalservice/noblecrm/client/controllers/ClientController.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping(value = "/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;


    @Autowired
    private UserInfoRepository userInfoRepository;

    private String uuid;

    @GetMapping("/all")
    public ResponseEntity<?> getAllClient() {
        List<UserDTO> client = clientService.getAllUsers();
        return new ResponseEntity<>(client, HttpStatus.OK);


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
        uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        user.setUserName(user.getUserName());
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

    @PostMapping("/delete")
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
