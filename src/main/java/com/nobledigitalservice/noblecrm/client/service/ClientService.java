package com.nobledigitalservice.noblecrm.client.service;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    List<UserDTO> getAllUsers();

    void addUser(UserDTO user);

    void updateUser(UserDTO updatedUser);

}
