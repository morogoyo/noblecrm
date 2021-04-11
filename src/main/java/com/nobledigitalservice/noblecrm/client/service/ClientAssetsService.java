package com.nobledigitalservice.noblecrm.client.service;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface ClientAssetsService {

    UserDTO findByEmail(String email);

}
