package com.nobledigitalservice.noblecrm.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordUtilityImpl implements  PasswordUtilityService{

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public String hashPassword(String password) {
        return encoder.encode(password);
    }
}
