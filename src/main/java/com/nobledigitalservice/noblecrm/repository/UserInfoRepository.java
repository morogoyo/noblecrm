package com.nobledigitalservice.noblecrm.repository;

import com.nobledigitalservice.noblecrm.client.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

//    UserInfo findByUserDtoUserName(String userName);
}
