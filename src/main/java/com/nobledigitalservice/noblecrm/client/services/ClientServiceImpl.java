package com.nobledigitalservice.noblecrm.client.services;


import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import com.nobledigitalservice.noblecrm.repository.UserDTORepository;
import com.nobledigitalservice.noblecrm.utilities.PasswordUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private UserDTORepository userRepo;

    @Autowired
    private PasswordUtilityService passwordUtilityService;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll();
    }


    @Override
    public Optional<UserDTO> getUser(UserDTO user) {
        Optional<UserDTO> byUserName = Optional.ofNullable(userRepo.findByEmail(user.getEmail()));
        if(!byUserName.isPresent()){
            return Optional.empty();
        }else{
            return byUserName;

        }

    }

    @Override
    public void addUser(UserDTO user) {
        String hashedPassword = passwordUtilityService.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);
    }

    @Override
    public Optional<UserDTO> updateUser(UserDTO updatedUser) {

        /* TODO need to add logic to be able to completely change all user field will be using id
         got to return the entity and grab the id to be able to change other staple fields like
         username and email.*/
        Optional<UserDTO> userRepoByUserName = Optional.ofNullable(userRepo.findByEmail(updatedUser.getEmail()));

        Optional<UserDTO> savedUser = null;
        if (!userRepoByUserName.isPresent()) {
            return Optional.empty();
        } else {
            userRepoByUserName.get().setEmail(updatedUser.getEmail());
            userRepoByUserName.get().setPassword(updatedUser.getPassword());
            userRepoByUserName.get().setRole(updatedUser.getRole());
            userRepoByUserName.get().setUserName(updatedUser.getUserName());
            savedUser = Optional.ofNullable(userRepo.save(userRepoByUserName.get()));
            return savedUser;
        }


    }

    @Override
    public void deleteUser(UserDTO userToDelete) {
        userRepo.delete(userToDelete);
    }
}
