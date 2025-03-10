package com.zelkulon.authmicroservice.core.domain.service.impl;

import com.zelkulon.authmicroservice.core.domain.model.User;
import com.zelkulon.authmicroservice.core.domain.service.interfaces.IAuthService;
import com.zelkulon.authmicroservice.core.domain.service.interfaces.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    private static final Logger logger = LogManager.getLogger(AuthService.class);
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> checkUser(String authToken) {

        boolean existiertDerUserMitDiesemToken = userRepository.einUserMitDiesemTokenExistiertInDerDatenBank(authToken);

        logger.info("existiert der user mit diesem token? " + existiertDerUserMitDiesemToken);

        if (!existiertDerUserMitDiesemToken) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            User user = userRepository.getUserByToken(authToken);
            return new ResponseEntity<>(user.getUserId(), HttpStatus.OK);
        }


    }

    @Override
    public ResponseEntity<?> loginUser(User searchedUser) {
        String searchedUserId = searchedUser.getUserId();
        String searchedUserPw = searchedUser.getPassword();
        User user = userRepository.selectUserByUserId(searchedUserId);

        if (user == null || user.getUserId() == null ||
                user.getPassword() == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        logger.info("bis hierhin gekommen " + searchedUserId + " " + searchedUserPw);

        if (user.getUserId().equals(searchedUserId) && user.getPassword().equals(searchedUserPw)) {
            String token = user.generateToken();
            HttpHeaders authHeader = new HttpHeaders();
            authHeader.add("Authorization", token);
            logger.info("im nächsten schritt speicher nutzer " + user.getUserId() + " mit dem token " + token);

            user.setToken(token);
            userRepository.save(user);


            logger.info("Nutzer Speicher Schritt getriggert " + userRepository.save(user));

            return new ResponseEntity<>(token, authHeader, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }



}