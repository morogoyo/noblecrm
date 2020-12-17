package com.nobledigitalservice.noblecrm.repository;

import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDTORepository extends JpaRepository<UserDTO, String> {

    UserDTO findByUserName(String userName);

}

