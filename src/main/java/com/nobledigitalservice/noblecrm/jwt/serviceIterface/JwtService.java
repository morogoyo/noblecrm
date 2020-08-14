package com.nobledigitalservice.noblecrm.jwt.serviceIterface;

import com.nobledigitalservice.noblecrm.client.model.UserDTO;

public interface JwtService {

    UserDTO findByUserNameAndPassword(String userName, String password);

}
