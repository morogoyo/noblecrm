package com.nobledigitalservice.noblecrm.client.controller;


import com.nobledigitalservice.noblecrm.client.model.UserInfo;
import com.nobledigitalservice.noblecrm.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired UserInfoRepository userInfoRepository;


    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUserInfo(){
        List<UserInfo> userInfo = userInfoRepository.findAll();
        return new ResponseEntity<>( userInfo, HttpStatus.OK);
    }

    @PostMapping("insert-user-info")
    public void addUser(){
/*       todo need to get data from jwt token for user to be able to insert information about a user
        will most likely be a search to then pull the required entity
          searching  and creating a new object to pass in populating the info from the form and the user dto from
       jwt token
*/
    }

}
