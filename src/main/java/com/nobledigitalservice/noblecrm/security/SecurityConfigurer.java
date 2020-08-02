package com.nobledigitalservice.noblecrm.security;

import com.nobledigitalservice.noblecrm.services.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationUserDetailsService myUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);


//        auth.userDetailsService(myUserDetailService);
    }
}
