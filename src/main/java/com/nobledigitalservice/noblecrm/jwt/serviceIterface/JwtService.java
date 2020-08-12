package com.nobledigitalservice.noblecrm.jwt.serviceIterface;

import com.nobledigitalservice.noblecrm.jwt.model.UserDTO;


public interface JwtService {

    UserDTO findByUserNameAndPassword(String userName, String password);

}
