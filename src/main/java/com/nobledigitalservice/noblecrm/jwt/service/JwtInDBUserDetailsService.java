package com.nobledigitalservice.noblecrm.jwt.service;

import com.nobledigitalservice.noblecrm.jwt.model.JwtUserDetails;
import com.nobledigitalservice.noblecrm.client.model.UserDTO;
import com.nobledigitalservice.noblecrm.jwt.repository.UserDTORepository;
import com.nobledigitalservice.noblecrm.jwt.serviceIterface.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Qualifier("inDatabase")
public class JwtInDBUserDetailsService implements UserDetailsService {

    Logger LOG = LoggerFactory.getLogger(JwtInDBUserDetailsService.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDTORepository userDTORepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<UserDTO> user = Optional.of(userDTORepository.findByUserName(username));
        LOG.info(user.get().getUserName());

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found for username " + username);
        }
            JwtUserDetails jwtUser = new JwtUserDetails(user.get().getId(),user.get().getUserName(),user.get().getPassword(),user.get().getRole());
            return jwtUser;

        }


    }
