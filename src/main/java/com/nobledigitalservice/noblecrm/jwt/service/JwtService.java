package com.nobledigitalservice.noblecrm.jwt.service;

import com.nobledigitalservice.noblecrm.client.model.UserDTO;

public interface JwtService {

    UserDTO findByUserNameAndPassword(String userName, String password);

}
