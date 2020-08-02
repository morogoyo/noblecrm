package com.nobledigitalservice.noblecrm.jwt.serviceIterface;

import com.nobledigitalservice.noblecrm.jwt.model.JwtUserDetails;

public interface JwtService {

    JwtUserDetails findByUserName(String email);

}
