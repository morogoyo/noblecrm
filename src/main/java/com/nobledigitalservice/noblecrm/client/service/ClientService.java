package com.nobledigitalservice.noblecrm.client.service;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {

    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUser(UserDTO userName);

    void addUser(UserDTO user);

    Optional<UserDTO> updateUser(UserDTO updatedUser);

    void deleteUser(UserDTO userToDelete);

}
