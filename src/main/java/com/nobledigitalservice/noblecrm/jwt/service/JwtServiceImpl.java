package com.nobledigitalservice.noblecrm.jwt.service;


import com.nobledigitalservice.noblecrm.jwt.model.UserDTO;
import com.nobledigitalservice.noblecrm.jwt.repository.UserDTORepository;
import com.nobledigitalservice.noblecrm.jwt.serviceIterface.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private UserDTORepository userDTOrepo;



    @Override
    public List<UserDTO> findByUserName(String userName) {
        Optional<UserDTO> optionalUser = Optional.ofNullable(userDTOrepo.findByUserName(userName));
        UserDTO user = null;
        List<UserDTO> userList = new ArrayList<>();

        if(!optionalUser.isPresent()){

            return new ArrayList<>();

        }else{

            user.setUserName(optionalUser.get().getUserName());
            user.setPassword(optionalUser.get().getPassword());
            user.setEmail(optionalUser.get().getEmail());
            user.setRole(optionalUser.get().getRole());
            userList.add(user);
            return userList;
        }


    }
}
