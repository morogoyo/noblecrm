package com.nobledigitalservice.noblecrm.jwt.service;


import com.nobledigitalservice.noblecrm.jwt.model.UserDTO;
import com.nobledigitalservice.noblecrm.jwt.repository.UserDTORepository;
import com.nobledigitalservice.noblecrm.jwt.serviceIterface.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private UserDTORepository userDTOrepo;

    @Autowired
    private PasswordEncoder encoder;

    int strength = 10;

    Logger LOG = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Override
    public UserDTO findByUserNameAndPassword(String userName, String password) {

//        TODO  "need to figure out what this encoder is doing"
// work factor of bcrypt


        LOG.info(userName);

        LOG.info(password);


        Optional<UserDTO> optionalUser = Optional.ofNullable(userDTOrepo.findByUserName(userName));
        UserDTO user = new UserDTO();
        LOG.info("////////////////////////////////////////////////////////////");
        LOG.info(optionalUser.get().getPassword() + " from database");
        LOG.info(encoder.matches(password,optionalUser.get().getPassword()) + " from bcrypt matcher");
        LOG.info("////////////////////////////////////////////////////////////");

        if (optionalUser.isPresent() && encoder.matches(password,optionalUser.get().getPassword())) {
            LOG.info("Password Matched");
            LOG.info(encoder.matches(password,optionalUser.get().getPassword())+" password match method");
            user.setUserName(optionalUser.get().getUserName());
            user.setPassword(optionalUser.get().getPassword());
            user.setEmail(optionalUser.get().getEmail());
            user.setRole(optionalUser.get().getRole());
            LOG.info(user.getUserName() + ", " + user.getPassword() + ", " + user.getEmail() + ", " + user.getRole());
            return user;
        } else {
            LOG.info("password did not match");
            return user;
        }
    }
}
