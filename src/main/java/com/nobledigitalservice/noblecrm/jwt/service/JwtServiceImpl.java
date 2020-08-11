package com.nobledigitalservice.noblecrm.jwt.service;


import com.nobledigitalservice.noblecrm.jwt.model.UserDTO;
import com.nobledigitalservice.noblecrm.jwt.repository.UserDTORepository;
import com.nobledigitalservice.noblecrm.jwt.serviceIterface.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private UserDTORepository userDTOrepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    Logger LOG = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Override
    public List<UserDTO> findByUserNameAndPassword(String userName, String password) {

//        TODO  "need to figure out what this encoder is doing"
        String userPassword = encoder.hashCode()   encode(password);

        LOG.info(userName);

        LOG.info(password);
        LOG.info(userPassword);

        Optional<UserDTO> optionalUser = Optional.ofNullable(userDTOrepo.findByUserName(userName));
        UserDTO user = new UserDTO();
        List<UserDTO> userList = new ArrayList<>();

        if(!optionalUser.isPresent() && optionalUser.get().getPassword() != userPassword){
                LOG.info("inside if block optional not true");
            return new ArrayList<>();

        }else{
            LOG.info("inside else creating object");

            user.setUserName(optionalUser.get().getUserName());
            user.setPassword(optionalUser.get().getPassword());
            user.setEmail(optionalUser.get().getEmail());
            user.setRole(optionalUser.get().getRole());
            userList.add(user);
            LOG.info(user.getUserName()+", "+user.getPassword()+", "+user.getEmail()+", "+user.getRole());
            return userList;
        }


    }
}
