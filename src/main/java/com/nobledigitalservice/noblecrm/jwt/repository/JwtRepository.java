package com.nobledigitalservice.noblecrm.jwt.repository;

import com.nobledigitalservice.noblecrm.jwt.model.JwtUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRepository extends JpaRepository<JwtUserDetails,String> {


    }
