/**
 * dastekin created for Zelkulon on 12.12.2024 the BlogController Class inside the package - com.zelkulon.zelkulonapi.port.controller
 *//*

package com.zelkulon.zelkulonapi.blogs.port.controller;
import com.zelkulon.zelkulonapi.Authorization;
import com.zelkulon.zelkulonapi.blogs.core.domain.model.BlogList;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.impl.BlogListService;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.BlogListRepository;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.BlogRepository;

import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.IBlogListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;



    */
/*@GetMapping(value = "/{blogListId}", produces = "application/json")
    public ResponseEntity<?> getSongListeMitBestimmterIdAnDenNutzerMitDemToken(
            @RequestHeader("Authorization") String authToken,
            @PathVariable("blogListId") Long songListId) {

        Mono<String> derAuthentifizierteUser = authUser(authToken);

        // Überprüfung, ob die Songliste existiert
        if (!gibtEsDieSongliste(songListId)) {
            logSongListeNichtExistiert();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String besitzerDerListe = gibBesitzerDerListe(songListId);
        String aktuellerBenutzer = derAuthentifizierteUser.block();

        // Überprüfung, ob der authentifizierte Benutzer der Besitzer ist
        if (Objects.equals(aktuellerBenutzer, besitzerDerListe)) {
            logBenutzerIstBesitzer();
            return service.gibMirDieBlogListeMitDerId(songListId);
        }

        // Überprüfung, ob die Liste öffentlich ist, wenn der Benutzer nicht der Besitzer ist
        if (istListeOeffentlich(songListId)) {
            logListeIstOeffentlich();
            return service.gibMirDieBlogListeMitDerId(songListId);
        }

        logZugriffVerboten();
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    private boolean gibtEsDieSongliste(Long id) {
        return service.gibtEsDieSonglisteMitDerID(id);
    }

    private String gibBesitzerDerListe(Long id) {
        return service.gibMirNameUserMitDieserBlogId(id);
    }

    private boolean istListeOeffentlich(Long id) {
        return service.istDieseListePublic(id);
    }

    private void logSongListeNichtExistiert() {
        myLogger.info("Die Blogliste existiert nicht");
    }

    private void logBenutzerIstBesitzer() {
        myLogger.info("Der User(token) ist der Owner");
    }

    private void logListeIstOeffentlich() {
        myLogger.info("Die Blogliste ist public");
    }

    private void logZugriffVerboten() {
        myLogger.info("Die Blogliste ist nicht public und der User(token) ist nicht der Owner");
    }
*//*


//POST
*/
/*
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postSongList(
            @RequestHeader("Authorization") String authToken,
            @RequestBody BlogList blogList) {

        // Guard #1: Token ist leer
        if (authToken == null || authToken.isEmpty()) {
            return new ResponseEntity<>("Unauthorized KEIN TOKEN", HttpStatus.UNAUTHORIZED);
        }

        try {

            Mono<String> derAuthentifizierteUser = authUser(authToken);
            return service.addBlogList(derAuthentifizierteUser.block(), blogList);

        } catch (WebClientResponseException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                return new ResponseEntity<>("Unauthorized FALSCHER TOKEN", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Delete

    //TODO: 400 oder 404?!
    @DeleteMapping(value = "/{blogListId}")
    public ResponseEntity<?> deleteSongListWithId(@RequestHeader("Authorization") String authToken, @PathVariable("blogListId") Long blogListId) {
        Mono<String> derAuthentifizierteUser = authUser(authToken);
        if (Objects.equals(derAuthentifizierteUser.block(), service.gibMirNameUserMitDieserBlogId(blogListId))) {
            if (!service.gibtEsDieSonglisteMitDerID(blogListId)) {
                myLogger.info("Die Blogliste existiert nicht");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                myLogger.info("Erfolgreich gelöscht");
                service.deleteThisBlogList(blogListId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else {
            myLogger.info("Der User(aus dem token) ist nicht der Owner der Blogliste!");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }


    // TODO: StatusCODES Ma Bidde in den Controller und nicht in den Service! Wat willste da mit den StatusCodes?! biste bekloppt meen besta?! :))) heha so rede ich mit mir selbst
    @PutMapping(value = "/{blogListId}", consumes = "application/json")
    public ResponseEntity<?> putSongListWithId(@RequestHeader("Authorization") String authToken, @PathVariable("blogListId") Long id, @RequestBody BlogList blogList) {
        Mono<String> derAuthentifizierteUser = authUser(authToken);

        if (Objects.equals(derAuthentifizierteUser.block(), service.gibMirNameUserMitDieserBlogId(id))) {
            return service.updateBlogListe(derAuthentifizierteUser.block(), id, blogList);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }*//*






@RestController
@RequestMapping(value = "/bloglists")
public class BlogListController {
    private static final Logger myLogger = LoggerFactory.getLogger(BlogListController.class);

    //@Autowired
    private final IBlogListService service;

    public BlogListController(BlogListRepository blogListRepository, BlogRepository blogRepository) {
        this.service = new BlogListService(blogListRepository, blogRepository);
    }

    */
/*
     * Das Hier ist die erste GET Anfrage aus dem Übungsblatt 3
     * Hier soll ein Get REQUEST mit dem Header Authorization dem @RequestParam (also /songLists?owner_id=...) übergeben werden
     * token=maxime und liste maxime dann private und public von maxime
     * token=maxime und liste jane dann nur public von jane
     * token=maxime und liste von nichtExistentemUser dann 404
     *//*

*/
/*
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllSongListObPrivateOderNichtVonOwner(@RequestHeader("Authorization") String authToken, @RequestParam(name = "owner_id") String ownerID) {

        Mono<String> derAuthentifizierteUser = authUser(authToken);
*//*



       */
/* // Mein GUARD
        if (!service.gibtEsDenUser(ownerID)) {
            myLogger.info("Der User existiert nicht");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        *//*
*/
/*
     * Wenn der authentifizierte User der Owner ist, dann gib alle SongLists zurück, ob private oder nicht
     * Wenn der authentifizierte User nicht der Owner ist, dann gib nur die public SongLists zurück
     *//*
*/
/*
        if (Objects.equals(derAuthentifizierteUser.block(), ownerID)) {
            return service.getAllBloglistsvomOwnerObPrivateOderNicht(derAuthentifizierteUser.block());
        } else {
            return service.getAllBlogsVonJemandAnderem(ownerID);
        }*//*



}
*/
