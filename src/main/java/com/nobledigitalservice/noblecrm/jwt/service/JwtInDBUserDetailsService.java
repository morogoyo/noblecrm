package com.nobledigitalservice.noblecrm.jwt.service;

import com.nobledigitalservice.noblecrm.jwt.model.JwtUserDetails;
import com.nobledigitalservice.noblecrm.jwt.serviceIterface.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class JwtInDBUserDetailsService implements UserDetailsService {

    @Autowired
    private JwtService jwtService;

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = null;

        try{
            user =  jwtService.findByUserName(username);
        }catch (Exception e){
            System.out.println(e);
        }



        return user;

    }


}
