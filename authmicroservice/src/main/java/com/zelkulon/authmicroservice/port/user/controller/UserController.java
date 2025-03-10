package com.zelkulon.authmicroservice.port.user.controller;

import com.zelkulon.authmicroservice.core.domain.model.User;
import com.zelkulon.authmicroservice.core.domain.service.impl.AuthService;
import com.zelkulon.authmicroservice.core.domain.service.interfaces.IAuthService;
import com.zelkulon.authmicroservice.core.domain.service.interfaces.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/auth")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private final IAuthService authService;

    public UserController(UserRepository userRepository) {
        this.authService = new AuthService(userRepository);
    }

    @GetMapping
    public ResponseEntity<?> checkUser(@RequestHeader("Authorization") String authToken) {
        logger.info("Auth Token empfangen " + authToken);
        logger.debug("EndPunkt URL : /auth");
        return authService.checkUser(authToken);
    }

    @PostMapping
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return authService.loginUser(user);
    }


}
