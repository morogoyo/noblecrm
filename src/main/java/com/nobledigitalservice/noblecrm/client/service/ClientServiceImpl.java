package com.nobledigitalservice.noblecrm.client.service;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import com.nobledigitalservice.noblecrm.repository.UserDTORepository;
import com.nobledigitalservice.noblecrm.utilities.PasswordUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private UserDTORepository userRepo;

    @Autowired
    private PasswordUtilityService passwordUtilityService;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void addUser(UserDTO user) {
        String hashedPassword = passwordUtilityService.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);
    }

    @Override
    public void updateUser(UserDTO updatedUser) {
        UserDTO userRepoByUserName = userRepo.findByUserName(updatedUser.getUserName());
        userRepoByUserName.setPassword(updatedUser.getEmail());
        userRepoByUserName.setPassword(updatedUser.getPassword());
        userRepoByUserName.setRole(updatedUser.getRole());
        userRepoByUserName.setUserName(updatedUser.getUserName());

    }
}
