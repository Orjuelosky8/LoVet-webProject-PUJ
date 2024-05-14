package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtRequest;
import com.example.demo.security.JwtResponse;
import com.example.demo.security.TokenProvider;
import com.example.demo.service.CustomUserDetailsService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    // private CustomUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        logger.debug("\n\n //////////// AUTENTICANDO...");
        logger.debug("\n\n //////////// "+ authenticationRequest.getUsername()+  "..." + authenticationRequest.getPassword());
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.getUsername());

        logger.debug("\n\n //////////// AUTENTICADOOOO... :D");
        
        // final String token = jwtTokenUtil.generateToken(userDetails);
        // logger.debug("\n\n //////////// asignamos tokensito... :D");

        // return ResponseEntity.ok(new JwtResponse(token));
        return ResponseEntity.ok()
                         .contentType(MediaType.APPLICATION_JSON)
                         .body("{\"message\": \"Autenticación exitosa para el usuario: " + userDetails.getUsername() + "\"}");
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            logger.debug("\n\n //////////// AUTENTICANDO2...");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            logger.debug("\n\n //////////// AUTENTICANDO3...");
        } catch (DisabledException e) {
            logger.debug("\n\n //////////// NO AUTENTICADO1...");
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            logger.debug("\n\n //////////// NO AUTENTICADO2...");
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }    
}

