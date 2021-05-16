package com.nobledigitalservice.noblecrm.client.service;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import com.nobledigitalservice.noblecrm.repository.UserDTORepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientAssetsImpl implements ClientAssetsService {

    @Autowired
    private UserDTORepository userDTORepository;

    @Override
    public UserDTO findByEmail(String email) {
        UserDTO client =  userDTORepository.findByEmail(email);
        return client;
    }
}
