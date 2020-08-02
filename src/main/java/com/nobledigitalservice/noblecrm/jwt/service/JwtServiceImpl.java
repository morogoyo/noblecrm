package com.nobledigitalservice.noblecrm.jwt.service;

import com.nobledigitalservice.noblecrm.jwt.model.JwtUserDetails;
import com.nobledigitalservice.noblecrm.jwt.repository.JwtRepository;
import com.nobledigitalservice.noblecrm.jwt.serviceIterface.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private JwtRepository jwtRepo;

    @Override
    public JwtUserDetails findByUserName(String userName) {
        JwtUserDetails user = null;
        try{
            user =  jwtRepo.getOne(userName);
       }catch (Exception e){
            System.out.println(e);
       }

        return user;
    }
}
