package com.nobledigitalservice.noblecrm.jwt.serviceIterface;

import com.nobledigitalservice.noblecrm.jwt.model.UserDTO;

import java.util.List;


public interface JwtService {

    List<UserDTO> findByUserName(String userName);

}
