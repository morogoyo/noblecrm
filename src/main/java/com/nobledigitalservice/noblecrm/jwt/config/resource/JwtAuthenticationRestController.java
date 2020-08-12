package com.nobledigitalservice.noblecrm.jwt.config.resource;

import com.nobledigitalservice.noblecrm.jwt.config.JwtTokenUtil;
import com.nobledigitalservice.noblecrm.jwt.model.JwtUserDetails;
import com.nobledigitalservice.noblecrm.jwt.model.UserDTO;
import com.nobledigitalservice.noblecrm.jwt.serviceIterface.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationRestController {

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtService jwtService;

    @Qualifier("inDatabase")
    @Autowired
    private UserDetailsService jwtInDBUserDetailsService;

    Logger LOG = LoggerFactory.getLogger(UserDetailsService.class);

    @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
            throws AuthenticationException {
        // Initial DB Query
        Optional<UserDTO> user = Optional.ofNullable(jwtService.findByUserNameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

//        Checks if optional is empty
        if (!user.isPresent()) {
            return new ResponseEntity<String>("User Name and Password are Incorrect", HttpStatus.NOT_FOUND);
        } else
            {
            LOG.info("////////////////////////////////////////////  controller " + user.get().getUserName());
            final UserDetails userDetails = (UserDetails) jwtInDBUserDetailsService
                    .loadUserByUsername(user.get().getUserName());

            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtTokenResponse(token));
        }
    }

    @RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) jwtInDBUserDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler({ AuthenticationException.class })
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        LOG.info(username + " authenticate methos");
        LOG.info(password + " authenticate methos");
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        LOG.info(username + " authenticate methos 2");
        LOG.info(password + " authenticate methos 2");

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }
}
