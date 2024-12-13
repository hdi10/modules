package com.zelkulon.authmicroservice.core.domain.service.interfaces;
import com.zelkulon.authmicroservice.core.domain.model.User;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

    /**
     * Prüft ob der User eingeloggt ist
     *
     * @param authToken - der Token der zur authentication dient
     * @return - der User der eingeloggt ist
     */
    ResponseEntity<?> checkUser(String authToken);

    /**
     * Loggt den User ein
     *
     * @param user -  der User der eingeloggt werden soll
     * @return - der Token der zur authentication dient
     */
    ResponseEntity<?> loginUser(User user);
}