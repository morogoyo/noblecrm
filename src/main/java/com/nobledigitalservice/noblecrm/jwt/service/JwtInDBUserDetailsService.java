package com.nobledigitalservice.noblecrm.jwt.service;

import com.nobledigitalservice.noblecrm.jwt.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Qualifier("inDatabase")
public class JwtInDBUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserDTORepository userDTO;

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        Optional<UserDTO> user = Optional.of(userDTO.findByUserName(username));


//        if (!user.isPresent()){
//            throw new UsernameNotFoundException("User not found for username "+ username);
//        }
        JwtUserDetails jwtUser = null;
////        JwtUserDetails jwtUser = new JwtUserDetails(user.get().getId(),user.get().getUserName(),user.get().getPassword(),user.get().getRole());
        return jwtUser;

    }


}
