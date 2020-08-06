package com.nobledigitalservice.noblecrm.jwt.repository;

import com.nobledigitalservice.noblecrm.jwt.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDTORepository extends JpaRepository<UserDTO,Long> {

    UserDTO findByUserName(String username);

}
